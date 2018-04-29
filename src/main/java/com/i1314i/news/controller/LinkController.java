package com.i1314i.news.controller;

import com.i1314i.news.mapper.LinkMapper;
import com.i1314i.news.po.Link;
import com.i1314i.news.po.Msg;
import com.i1314i.news.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/html/adminhtml")
public class LinkController {
    @Autowired
    private LinkMapper linkMapper;
    private  Msg msg;
    Link linksql=null;
    @RequestMapping(value = "/linkcontrol")
    public String LinkMange(Model model,HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("user_session");
        List<Link>links=linkMapper.selectLinks();
        model.addAttribute("links",links);
        model.addAttribute("user",user);
        return "link_control";
    }

    @RequestMapping(value = "/addLink",method = {RequestMethod.POST})
    public @ResponseBody Msg addLink(@RequestBody Link link)throws Exception{
        Link linsql = null;
        if(link.getLid()!=0){
            linsql=linkMapper.findLinkById(link.getLid());
        }

        msg=new Msg();
        msg.setSuccess(0);
        if(linsql==null){
            linkMapper.insertLink(link);
            msg.setSuccess(1);
            msg.setMsg("添加数据成功");
        }else{
            link.setLid(linsql.getLid());
            linkMapper.updateLink(link);
            msg.setSuccess(1);
            msg.setMsg("修改数据成功");
        }
        return msg;
    }

    @RequestMapping(value = "/getLink",method = {RequestMethod.POST})
    public @ResponseBody Link link(@RequestBody Link link)throws Exception{

        if(link.getLid()!=0){
            linksql=linkMapper.findLinkById(link.getLid());
            if(linksql!=null){
                linksql.setSuccess(1);
            }else{
                linksql.setSuccess(0);
            }
        }

        return linksql;
    }



    @RequestMapping(value = "/deleteLink",method = {RequestMethod.POST})
    public @ResponseBody Msg deleMsg(@RequestBody Link link)throws Exception{
        msg=new Msg();
        linksql=null;
        if(link.getLid()!=0){
            linksql=linkMapper.findLinkById(link.getLid());
            if(linksql==null){
                msg.setSuccess(0);
                msg.setMsg("所删除资源不存在");
            }else{
                linkMapper.deleteLinkById(link.getLid());
                msg.setSuccess(1);
                msg.setMsg("删除成功");
            }
        }
        return msg;
    }

}

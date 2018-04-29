package com.i1314i.news.controller;
import com.i1314i.news.po.*;
import com.i1314i.news.service.Exception.TheException;
import com.i1314i.news.service.NewsService;
import com.i1314i.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/html/adminhtml")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    private Msg msg=null;
    private User usersql;



    @RequestMapping(value = "/msgnotice",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getNewsList(ModelAndView modelAndView , @RequestParam(required = false)Integer type, @RequestParam(required = false)Integer currPage, HttpServletRequest request)throws Exception{

        if(currPage==null&&type==null){
            currPage=1;
            type=1;
        }else if(type==null){
            type=0;
        }else if(currPage==null||currPage==0){
            currPage=1;
        }

        int pageSzie=10;
        PageBean<News> pageBean= newsService.findAll(currPage,pageSzie,type);


        if(type==0){
            pageBean.setTypename("全部");
        }else {
            String typename=newsService.findTypeById(type);
            pageBean.setTypename(typename);
        }

        pageBean.setPagecode(currPage);
        pageBean.setTypeid(type);

        //页码
        int totalrecord= 0;
        if(type==0){
            totalrecord= userService.findAllCounts();
        }else{
           totalrecord=newsService.findAllCount(type);
        }

        //总页数
        int totalpage = totalrecord/pageSzie;
        if(totalpage==0){
            totalpage=1;
        }else{
            totalpage+=1;
        }

        pageBean.setTotalpage(totalpage);
        List<Type> Types=newsService.findAllType();
        User user= (User) request.getSession().getAttribute("user_session");
        if(user!=null){
            modelAndView.addObject("user",user);

        }
        modelAndView.addObject("types",Types);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.setViewName("msg_notice");
        return modelAndView;
    }


    @RequestMapping(value = "/msgpublish",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView InsertNews (ModelAndView modelAndView,@RequestParam(required = false) Integer id,@RequestParam(required = false) Integer type,HttpServletRequest request)throws Exception{

        String url="";
        List<Type> types=newsService.findAllType();

        if((type==null&&id==null)||(type==null||type==0)||(id==null)){
            url= "msg_publish";
        }else{


            News news = newsService.findNewsById(id);
            if(news!=null){
                modelAndView.addObject("news",news);
                url="msg_publish";
            }else{
              url="redirect:msgpublish.html" ;
            }



        }
        User user= (User) request.getSession().getAttribute("user_session");
        if(user!=null){
            modelAndView.addObject("user",user);
        }

        modelAndView.addObject("types",types);
        modelAndView.setViewName(url);
        return modelAndView;
    }

    @RequestMapping(value = "/updateandaddNews",method = {RequestMethod.POST})
    public @ResponseBody Msg updateandaddNews(@RequestBody News news)throws Exception{
        msg=new Msg();
       if((news.getTitle()==null||news.getTitle().trim().equalsIgnoreCase(""))){
           msg.setSuccess(0);
           msg.setMsg("新闻标题不能为空");
       }else if(news.getContent()==null||news.getContent().trim().equalsIgnoreCase("")){
           msg.setSuccess(0);
           msg.setMsg("新闻内容不能为空");
       } else{
           if(newsService.isNews(news.getId())){
               newsService.updateNews(news);
               msg.setSuccess(1);
               msg.setMsg("修改数据成功");
           }else{
               Date date = new Date();
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
               String dates=dateFormat.format(date);
               news.setDates(dates);
               newsService.insertNews(news);
               msg.setSuccess(1);
               msg.setMsg("添加数据成功");
           }
       }

        return msg;

    }


    @RequestMapping(value = "/deleteNews",method = {RequestMethod.POST})
    public @ResponseBody Msg deleteNews(@RequestBody News news)throws Exception{
        System.out.println(news.getId());
        msg=new Msg();
        int su=newsService.deleteNews(news.getId());
        if(su==1){
            msg.setSuccess(1);
            msg.setMsg("删除成功");
        }else {
            msg.setSuccess(0);
            msg.setMsg("要删除的新闻不存在");
        }
        return msg;
    }

    @RequestMapping(value = "/usercontrol")
    public ModelAndView Users(ModelAndView modelAndView,HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("user_session");
        List<User>users=userService.findUsersList();
        modelAndView.addObject("users",users);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user_control");
        return modelAndView;
    }

    @RequestMapping(value = "/getUser",method = {RequestMethod.POST})
    public @ResponseBody User userly(@RequestBody User user)throws Exception{
       usersql=null;
        System.out.println(user.getUid());
        if(user.getUid()!=0){
            usersql=userService.findUserById(user.getUid());
            System.out.println(usersql.getUsername());
            if(usersql!=null){
                usersql.setSuccess(1);
            }else{
                usersql=new User();
                usersql.setSuccess(0);
            }
        }
        System.out.println(usersql.getUid());
        return usersql;
    }

    @RequestMapping(value = "/addUser",method = {RequestMethod.POST})
    public @ResponseBody Msg  addUser(@RequestBody User user)throws Exception{
        User usersql=null;
        User Usersql1=null;
        if(user.getUid()!=0){
            usersql=userService.findUserById(user.getUid());
        }
        msg=new Msg();
        msg.setSuccess(0);

        if(user.getPassword().trim().equalsIgnoreCase("")||user.getUsername().trim().equalsIgnoreCase("")){
            msg.setSuccess(0);
            msg.setMsg("密码或账号不能为空");
        }else if(user.getUsername().length()<=2){
            msg.setSuccess(0);
            msg.setMsg("账号长度必须大于2");
        } else{
           if(usersql==null){
               Usersql1=userService.findUserByName(user.getUsername());
               if(Usersql1!=null){
                   System.out.println(user.getUsername());
                   if(Usersql1.getUsername().equalsIgnoreCase(user.getUsername())){
                       msg.setSuccess(0);
                       msg.setMsg("账号已存在");
                   }
               }else {
                   user.setType(0);
                   userService.insertUser(user);
                   System.out.println(user.getUsername());
                   msg.setSuccess(1);
                   msg.setMsg("添加数据成功");
               }


            }else{
                userService.updateUser(user);
                msg.setSuccess(1);
                msg.setMsg("修改数据成功");
            }
        }
        return msg;
    }


    @RequestMapping(value = "/deleteUser",method = {RequestMethod.POST})
    public @ResponseBody Msg deleMsg(@RequestBody User user)throws Exception{
        msg=new Msg();
        usersql=null;
        if(user.getUid()!=0){
            usersql=userService.findUserById(user.getUid());
            if(usersql==null){
                msg.setSuccess(0);
                msg.setMsg("所删除资源不存在");
            }else{
                userService.deleteUserById(user.getUid());
                msg.setSuccess(1);
                msg.setMsg("删除成功");
            }
        }
        return msg;
    }


    @RequestMapping(value = "/quitUser")
    public  ModelAndView quit(ModelAndView modelAndView,HttpServletRequest request)throws Exception{

        request.getSession().invalidate();

        modelAndView.setViewName("redirect:/admin/html/login/login.html");
        return modelAndView;

    }

    }

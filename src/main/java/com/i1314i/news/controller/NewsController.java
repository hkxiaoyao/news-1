package com.i1314i.news.controller;

import com.i1314i.news.mapper.LinkMapper;
import com.i1314i.news.po.*;
import com.i1314i.news.service.NewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class NewsController {
    private static Logger logger=Logger.getLogger(NewsController.class);
    @Autowired
    private NewsService newsService;
    @Autowired
    private LinkMapper linkMapper;
    @RequestMapping(value = "index",method = {RequestMethod.GET,RequestMethod.POST})
    public String findAllTyoe(Model model)throws Exception{
        List<Type> Types=newsService.findAllType();
        int typenumber=newsService.findAllCountType();

        for(int i=0;i<Types.size();i++){
            PageBean<News> pageBean = newsService.findAll(1,8,Types.get(i).getId());
            Types.get(i).setPageBean(pageBean);
        }


        List<Link>links = linkMapper.selectLinks();
        model.addAttribute("links",links);
        model.addAttribute("typenumber",typenumber);
        model.addAttribute("types",Types);
        return "foreground/index";
    }

    @RequestMapping(value = "/newslist",method = {RequestMethod.POST,RequestMethod.GET})
    public String NewsList(Model model,@RequestParam(required = false) Integer type,
                           @RequestParam(required = false) Integer currPage)throws Exception{

        if(currPage==null&&type==null){
            currPage=1;
            type=1;
        } else if(currPage==null){
            currPage=1;
        }else if(type==null){
            type=1;
        }
        //种类
        List<Type> Types=newsService.findAllType();

        //热门
        List<News>NewsByHot=newsService.findByHot(1,8);
        List<News>NewsOfTime=newsService.findAllTimes(1,8);
        int pageSize=15;
        PageBean<News> pageBean = newsService.findAll(currPage,pageSize,type);

        int totalrecord=newsService.findAllCount(type);
        int totalpage = totalrecord/pageSize;
        if(totalpage==0){
            totalpage=1;
        }else{
            totalpage+=1;
        }


        String typename=newsService.findTypeById(type);
        pageBean = newsPageBean(pageBean,type,typename,currPage,pageSize,totalpage,totalrecord,NewsByHot,NewsOfTime);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("types",Types);
        return "foreground/newsList";


    }

    //页面数据
    public PageBean<News> newsPageBean(PageBean<News> pageBean,int typeid,String Typename,int pagecode,int pagesize, int totalpage,int totalrecord,List<News>hot,List<News>newsOfTime){
        PageBean<News>newsPageBean = pageBean;
        newsPageBean.setPagecode(pagecode);
        newsPageBean.setPagesize(pagesize); //页面大小
        newsPageBean.setTotalpage(totalpage); //总页数
        newsPageBean.setTotalrecord(totalrecord);//总记录数
        newsPageBean.setTypeid(typeid);
        newsPageBean.setTypename(Typename);
        newsPageBean.setHot(hot);
        newsPageBean.setNewsOfTime(newsOfTime);
        return newsPageBean;
    }

    @RequestMapping(value = "/content",method = {RequestMethod.POST,RequestMethod.GET})
    public String NewsContent(Model model,@RequestParam(required = false) Integer id,@RequestParam(required = false)Integer type) throws Exception {

        if(id==null&&type==null){
            id=1;
            type=1;
        } else if(id==null){
            id=1;
        }else if(type==null){
            type=1;
        }


        //浏览量
        int hits=newsService.findByHits(id);
        hits++;
        newsService.updateHits(id,hits);


        //上一篇下一篇
        News newsc = newsService.findNewsById(id);
        int count=newsService.findCountNews();
        News lastnew=null;
        News nextnew=null;
        if(id>=1&id<count){
            nextnew=newsService.findNewsById(id+1);
        }
        if(id>1&&id<=count){
            lastnew=newsService.findNewsById(id-1);
        }


        List<Type> Types=newsService.findAllType();
        List<News>NewsByHot=newsService.findByHot(1,8);
        List<News>NewsOfTime=newsService.findAllTimes(1,8);
        ContentBean<News>contentBean=new ContentBean<News>();
        String types=newsService.findTypeByNewsd(id,type);
        contentBean=newsContentBean(contentBean,types,count,newsc,NewsByHot,NewsOfTime,lastnew,nextnew);

        model.addAttribute("contentBean",contentBean);
        model.addAttribute("types",Types);
        return "foreground/newsShow";
    }


public ContentBean<News>newsContentBean(ContentBean<News> contentBean,String types,int count,
                                        News newsc,List<News>NewsByHot, List<News>NewsOfTime,
                                        News lastnew,News nextnew ){
    contentBean.setType(types); //类型
    contentBean.setCount(count);//数量
    contentBean.setNews(newsc);//new
    contentBean.setHot(NewsByHot);//热点新闻
    contentBean.setNewsOfTime(NewsOfTime);//最新新闻
    contentBean.setLastnew(lastnew);//上一条
    contentBean.setNextnew(nextnew);//下一条
    return contentBean;
}

}
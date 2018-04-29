package com.i1314i.news.service.Impl;

import com.i1314i.news.mapper.NewsMapper;
import com.i1314i.news.po.News;
import com.i1314i.news.po.PageBean;
import com.i1314i.news.po.Type;
import com.i1314i.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.*;

public class NewsServicelmpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    public List<News> findNewByType(int type) throws Exception {
        return newsMapper.findNewByType(type);
    }

    public News findNewsByName(String name) throws Exception {
        return newsMapper.findNewsByName(name);
    }

    public News findNewsById(int id) throws Exception {
        return newsMapper.findNewsById(id);
    }

    public String findTypeById(int id)throws Exception{
        return newsMapper.findTypeById(id);
    }
    public List<Type> findAllType() throws Exception {

        List types=newsMapper.findAllType();
        List<Type>typeslist = new ArrayList<Type>();


        Iterator iterator= types.iterator();
        while(iterator.hasNext()){

            Type type= (Type) iterator.next();
            if(!typeslist.contains(type)){
                typeslist.add(type);
            }

        }
        return typeslist;
    }

    public void insertNews(News news) throws Exception {


        newsMapper.insertNews(news);
    }

    public int findByHits(int id)throws Exception{
        return newsMapper.findByHits(id);
    }

    public void updateHits(int id,int hits)throws Exception{
        Map<String,Object> hit=new HashMap<String, Object>();
        hit.put("id",id);
        hit.put("hits",hits);
        newsMapper.updateHits(hit);
    }

    public String findTypeByNewsd(int id,int type)throws Exception{
        Map<String,Object> data=new HashMap<String, Object>();
        data.put("id",id);
        data.put("type",type);
        return newsMapper.findTypeByNewsd(data);
    }

    @Override
    public int deleteNews(Integer id) throws Exception {
        int msg;
        msg=0;
        News news=newsMapper.findNewsById(id);
        if(news==null){
            msg=0;
        }else {
            newsMapper.deleteNews(id);
            msg=1;
        }
        return msg;
    }

    public int findCountNews()throws Exception{
        return newsMapper.findCountNews();
    }

    @Override
    public boolean isNews(int id) throws Exception {

        boolean is=false;
        News news=newsMapper.findNewsById(id);
        if(news==null){
            is=false;
        }else{
            is=true;
        }
        return is;
    }


    public List<News>findByHot(int currPage, int pageSize)throws Exception{
        Map<String,Object>data=new HashMap<String, Object>();
        data.put("currIndex",currPage);
        data.put("pageSize",pageSize);
        return newsMapper.findByHot(data);
    }

    public void updateNews(News news) throws Exception {
        News newls=newsMapper.findNewsById(news.getId());

        if(news.getFroms()==null||news.getFroms().trim().equalsIgnoreCase("")){
            news.setFroms("未知");
        }else if(news.getWriter()==null||news.getWriter().trim().equalsIgnoreCase("")){
            news.setWriter("未知");
        }
        if(newls.getDates()!=null){
            news.setDates(newls.getDates());
        }else {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dates=dateFormat.format(date);
            news.setDates(dates);
        }
        news.setHits(newls.getHits());
        newsMapper.updateNews(news);
    }

    public int findAllCountType() throws Exception {
        return newsMapper.findAllCountType();
    }

    public PageBean findAll(int currPage, int pageSize,int type)throws Exception{
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("currIndex",(currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        PageBean<News>pageBean=new PageBean<News>();
        if(type==0){
            pageBean.setBeanList(newsMapper.findAlls(data));
        }else {
            data.put("type",type);
            pageBean.setBeanList(newsMapper.findAll(data));
        }
        return pageBean;
    }



    public int findAllCount(int type)throws Exception{
        return newsMapper.findAllCount(type);
    }

    public List<News>findAllTimes(int currPage, int pageSize)throws Exception{
        Map<String,Object>data=new HashMap<String, Object>();
        data.put("currIndex",currPage);
        data.put("pageSize",pageSize);
        return newsMapper.findAllTimes(data);
    }


}
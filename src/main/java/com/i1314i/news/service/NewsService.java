package com.i1314i.news.service;

import com.i1314i.news.po.News;
import com.i1314i.news.po.PageBean;
import com.i1314i.news.po.Type;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface NewsService {
    public List<News>findNewByType(int type)throws Exception;
    public News findNewsByName(String name)throws Exception;
    public News findNewsById(int id)throws Exception;
    public String findTypeById(int id)throws Exception;
    public List<Type> findAllType()throws Exception;
    public void insertNews(News news)throws Exception;
    public void updateNews(News news)throws Exception;
    public int findAllCountType()throws Exception;
    public PageBean<News> findAll(int currPage, int pageSize,int type)throws Exception;
    public int findAllCount(int type)throws Exception;
    public int findByHits(int id)throws Exception;
    public void updateHits(int id,int hits)throws Exception;
    public List<News>findByHot(int currPage, int pageSize)throws Exception;
    public List<News>findAllTimes(int currPage, int pageSize)throws Exception;
    public int findCountNews()throws Exception;

    public boolean isNews(int id)throws Exception;
    public String findTypeByNewsd(int id,int type)throws Exception;
    public int deleteNews(Integer id)throws Exception;

}

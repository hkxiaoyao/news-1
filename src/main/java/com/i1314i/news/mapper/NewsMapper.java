package com.i1314i.news.mapper;

import com.i1314i.news.po.News;
import com.i1314i.news.po.PageBean;
import com.i1314i.news.po.Type;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface NewsMapper {
     List<News> findNewByType(int type)throws Exception;
     News findNewsByName(String name)throws Exception;
     News findNewsById(int id)throws Exception;
     String findTypeById(int id)throws Exception;
     List<Type> findAllType()throws Exception;
     void insertNews(News news)throws Exception;
     void updateNews(News news)throws Exception;
     int findAllCountType()throws Exception;
     List<News> findAll(Map<String,Object> data)throws Exception;
     List<News> findAlls(Map<String,Object> data)throws Exception;
     int findAllCount(int type)throws Exception;
     List<News>findByHot(Map<String,Object> data)throws Exception;
     int findCountNews()throws Exception;
     String findTypeByNewsd(Map<String,Object> data)throws Exception;
     int findByHits(int id)throws Exception;
     void updateHits(Map<String,Object> hits)throws Exception;
     List<News>findAllTimes(Map<String,Object> data)throws Exception;
     void deleteNews(Integer id)throws Exception;
}

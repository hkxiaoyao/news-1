package com.i1314i.news.mapper;

import com.i1314i.news.po.Link;

import java.util.List;

public interface LinkMapper {
     void insertLink(Link link) throws Exception;
     void updateLink(Link link) throws Exception;
     List<Link>selectLinks()throws Exception;
     Link findLinkById(int lid)throws Exception;
     void deleteLinkById(int lid)throws Exception;
}

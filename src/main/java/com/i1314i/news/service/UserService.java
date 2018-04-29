package com.i1314i.news.service;


import com.i1314i.news.po.News;
import com.i1314i.news.po.PageBean;
import com.i1314i.news.po.User;
import com.i1314i.news.service.Exception.TheException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {
    public User findUserById(int uid)throws Exception;
    public List<User> findUsersList()throws Exception;
    public void insertUser(User user)throws Exception;
    public boolean isadminUser(User user,HttpServletRequest request) throws TheException;
    public int findAllCounts()throws Exception;
    public void updateUser(User user)throws Exception;
    public void deleteUserById(int uid)throws Exception;
    public User findUserByName(String username)throws Exception;

}

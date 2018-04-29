package com.i1314i.news.mapper;

import com.i1314i.news.po.News;
import com.i1314i.news.po.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
     User findUserById(int uid)throws Exception;
     List<User>findUsersList()throws Exception;
     void insertUser(User user)throws Exception;
     int findAllCounts()throws Exception;
     void updateUser(User user)throws Exception;
     User findUserByName(String username)throws Exception;
     void deleteUserById(int uid)throws Exception;

}

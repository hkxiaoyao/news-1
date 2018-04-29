package com.i1314i.news.service.Impl;

import com.i1314i.news.po.User;
import com.i1314i.news.service.Exception.TheException;
import com.i1314i.news.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 平行时空
 * @created 2018-04-28 19:36
 **/
public class UserServiceimpl2 implements UserService {
    @Override
    public User findUserById(int uid) throws Exception {
        return null;
    }

    @Override
    public List<User> findUsersList() throws Exception {
        return null;
    }

    @Override
    public void insertUser(User user) throws Exception {

    }

    @Override
    public boolean isadminUser(User user, HttpServletRequest request) throws TheException {
        return false;
    }

    @Override
    public int findAllCounts() throws Exception {
        return 0;
    }

    @Override
    public void updateUser(User user) throws Exception {

    }

    @Override
    public void deleteUserById(int uid) throws Exception {

    }

    @Override
    public User findUserByName(String username) throws Exception {
        return null;
    }
}

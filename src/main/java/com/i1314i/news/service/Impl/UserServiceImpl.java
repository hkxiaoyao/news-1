package com.i1314i.news.service.Impl;


import com.i1314i.news.service.Exception.TheException;
import com.i1314i.news.service.UserService;
import com.i1314i.news.mapper.UserMapper;
import com.i1314i.news.po.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private static Logger logger= (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int  uid) throws Exception {
        return userMapper.findUserById(uid);
    }

    public List<User> findUsersList() throws Exception {
        return userMapper.findUsersList();
    }

    public void insertUser(User user) throws Exception {
         userMapper.insertUser(user);
    }

    @Override
    public boolean isadminUser(User user, HttpServletRequest request) throws TheException {
        User usersql= null;
        boolean state=false;
        if(user!=null&&!(user.getUsername().trim().isEmpty()||user.getPassword().trim().isEmpty())){
            try {
                usersql = userMapper.findUserByName(user.getUsername());
            } catch (Exception e) {
                logger.error("数据查询失败请稍后再试");
                throw new TheException("数据查询失败请稍后再试");

            }

            if(usersql!=null){
                if(user.getUsername().equals(usersql.getUsername())&&
                        user.getPassword().equals(usersql.getPassword())) {
                    state = true;
                    request.getSession().setAttribute("user_session",usersql);
                }else {
                    logger.info("用户名："+usersql.getUid()+":"+user.getUsername()+"| 错误信息：密码或者账号错误");
                    throw new TheException("密码或者账号错误");
                }
            }else{
                logger.info("用户名："+user.getUsername()+" |错误信息：用户不存在");
                throw new TheException("密码或者账号错误");
            }


        }

        return state;
    }

    @Override
    public int findAllCounts() throws Exception {
        return userMapper.findAllCounts();
    }
    public void updateUser(User user)throws Exception{
         userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(int uid) throws Exception {
        userMapper.deleteUserById(uid);
    }

    @Override
    public User findUserByName(String username) throws Exception {
        return userMapper.findUserByName(username);
    }


}

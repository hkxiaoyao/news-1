package com.i1314i.news.controller;

import com.i1314i.news.po.Msg;
import com.i1314i.news.po.User;
import com.i1314i.news.service.Exception.TheException;
import com.i1314i.news.service.NewsService;
import com.i1314i.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    private Msg msg=null;
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public @ResponseBody Msg AddNewUser(@RequestBody User user, HttpServletRequest request){
        msg=new Msg();
        boolean isuser= false;
        try {
            isuser = userService.isadminUser(user,request);
        } catch (TheException e) {
            msg.setSuccess(0);
            msg.setMsg(e.getMessage());
            return msg;
        }
        if(isuser){
            msg.setMsg("成功");
            msg.setSuccess(1);
        }
        return msg;
    }

    @RequestMapping(value = "/logins")
    public String  lo(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.getRequestDispatcher("/admin/html/login/login.html").forward(request,response);
        return "";
    }


}

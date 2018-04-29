package com.i1314i.news.HandlerInterceptor;

import com.i1314i.news.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        if(url.indexOf("adminhtml")<0){
            return true;
        }

        User user= (User) httpServletRequest.getSession().getAttribute("user_session");
        if(user!=null){
            return true;
        }else{
            String urls=httpServletRequest.getContextPath();
            httpServletResponse.sendRedirect(urls+"/admin/html/login/login.html");
        }




        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

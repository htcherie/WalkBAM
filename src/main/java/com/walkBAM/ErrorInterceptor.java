package com.walkBAM;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ErrorInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("进入拦截器");
        HttpSession session = request.getSession();

        System.out.println(request.getServletPath()+"------------"+session.getAttribute("user"));
        if(session.getAttribute("user")==null) {
            System.out.println("12312312312312312312312312");
            response.sendRedirect("/walkBAM/login.html");
            return false;

        }
            return true;
    }



}

package com.walkBAM.controller;

import com.walkBAM.util.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class EscController {


    @RequestMapping("/escBAM.action")
    public ModelAndView escBAM(ModelAndView mav, HttpServletRequest request, HttpServletResponse response){
        System.out.println("escBAM...");
        HttpSession session = request.getSession();
        ServletContext application = session.getServletContext();
        System.out.println(session.getId());
        String userName = CookieUtils.getCookie(request,"user");
        if (application.getAttribute(userName) != null){
            System.out.println("app"+application.getAttribute(userName));
            application.removeAttribute(userName);
            session.removeAttribute("user");
            mav.setViewName("redirect:login.html?time="+new Date());
            CookieUtils.removeCookie(request,response,"msg");
        }
        return mav;
    }
}

package com.walkBAM.controller;

import com.walkBAM.pojo.User;
import com.walkBAM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller

public class LoginController {
    @Autowired
    private UserService us;



    @RequestMapping("/login.action")
    public String login(User user,String rembername, HttpServletRequest request, HttpServletResponse response){
        System.out.println(user.getU_nickname()+"\t"+user.getU_password()+"\t"+rembername);

        if (us.findUser(user,rembername,request.getSession(),request,response)) {

            return "redirect:index.html?time="+new Date();
        } else {

            return "redirect:login.html?time="+new Date();
        }
    }



}

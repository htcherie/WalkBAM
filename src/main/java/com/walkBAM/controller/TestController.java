package com.walkBAM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(Model mod){
        mod.addAttribute("index","a");
        System.out.println("这是一个测试");
        return "forward:login.html";
    }
}

package com.walkBAM.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    public static String getCookie(HttpServletRequest request, String cookieName){
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void writeCookie(HttpServletResponse response, String cookieName, String value){
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }



    public static void saveCookie( String cookieName,String value, HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        if (cookie==null||cookie.length==0)
            return;
        for (Cookie c : cookie) {
            if (cookieName.equals(c.getName())) {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        // 实例化一个Cookie
        Cookie cookie1 = new Cookie(cookieName, value);
        // 设置Cookie的生命期限10分钟
        cookie1.setMaxAge(1800);
        // 添加Cookie到客户端
        response.addCookie(cookie1);

    }
    public static void removeCookie(HttpServletRequest request,HttpServletResponse response, String cookieName){
        Cookie[] cookies = request.getCookies();
        if (cookies==null||cookies.length==0)
            return;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(cookieName)){
                System.out.println("删除cookie"+cookie.getValue());
                cookie.setMaxAge(0);// 立即销毁cookie
                response.addCookie(cookie);
            }
        }
    }
}

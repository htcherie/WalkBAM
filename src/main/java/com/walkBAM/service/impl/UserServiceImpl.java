package com.walkBAM.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.walkBAM.dao.UserDao;
import com.walkBAM.pojo.User;
import com.walkBAM.service.UserService;
import com.walkBAM.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@AutoConfigureAfter({UserDao.class})
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean findUser(User user,String rembername, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        User user1 = userDao.selectUser(user);
        String username = "";
        ServletContext application = session.getServletContext(); // 获取application
        if (user1 != null && user1.getU_root() == 3) {

            username = user1.getU_nickname();
            System.out.println("app:" + application.getAttribute(username));
            if (application.getAttribute(username) == null) { // 说明还没有用户登录
                CookieUtils.saveCookie("user",username, response, request);
                CookieUtils.removeCookie(request,response,"msg");
                session.setAttribute("user",username);
                application.setAttribute(username, session.getId());
                if (rembername.equals("true")){
                    CookieUtils.saveCookie("rembername","rember", response, request);
                } else if (rembername.equals("false")){
                    CookieUtils.saveCookie("rembername","norember", response, request);
                }

                return true;
            } else {
                CookieUtils.saveCookie("msg","该用户已登陆", response, request);
                //用户已登录
                return false;
            }
        } else {
            CookieUtils.saveCookie("msg","用户名或密码错误", response, request);
            return false;
        }
    }


    @Override
    public Page<Map<String, Object>> findAllUser(Integer page, Integer rows, String search, String u_root, String u_cert) {

        PageHelper.startPage(page, rows);
        Page<Map<String, Object>> list = (Page<Map<String, Object>>) userDao.selectAllUser(search, u_root, u_cert);
        System.out.println("findAllUser:...");
        for (Map<String, Object> m : list) {
            System.out.println(m.get("u_id") + "\t" + m.get("u_name"));
        }
        return list;
    }

    @Override
    public boolean addUser(User user) {
        if (userDao.insertUser(user) > 0)
            return true;
        return false;
    }

    @Override
    public boolean modifyUser(User user) {
        if (userDao.updateUser(user) > 0)
            return true;
        return false;
    }

    @Override
    public boolean modifyAdminPwd(String pwd, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setU_password(pwd);
        if (userDao.updateAdminPwd(user) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean destroyUser(Integer u_id) {
        if (userDao.deleteUser(u_id) > 0)
            return true;
        return false;
    }
}

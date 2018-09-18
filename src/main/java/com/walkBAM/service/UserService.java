package com.walkBAM.service;

import com.github.pagehelper.Page;
import com.walkBAM.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
    public boolean findUser(User user,String rembername, HttpSession session ,HttpServletRequest request, HttpServletResponse response);

    public Page<Map<String, Object>> findAllUser(Integer page,Integer rows,String search,String u_root,String u_cert);

    public boolean addUser(User user);

    public boolean modifyUser(User user);

    public boolean modifyAdminPwd(String pwd,HttpSession session);

    public boolean destroyUser(Integer u_id);

 }

package com.walkBAM.dao;

import com.walkBAM.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public User selectUser(@Param("user") User user);

    public List<Map<String,Object>> selectAllUser(@Param("search") String search,@Param("u_root")String u_root,@Param("u_cert")String u_cert);

    public int insertUser(@Param("user") User user);

    public int updateUser(@Param("user") User user);

    public int updateAdminPwd(@Param("user") User user);

    public int deleteUser(@Param("u_id") Integer u_id);
}

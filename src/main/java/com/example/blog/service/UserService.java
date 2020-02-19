package com.example.blog.service;

import com.example.blog.bean.UserBean;

import java.util.List;

/**
 * @author:Sun Hongwei
 * @2020/2/18 下午9:07
 * File Description：
 */
public interface UserService {
    UserBean loginIn(String name,String password);

    //根据ID查询用户信息
    UserBean queryUserById(String id);

    //插入新的用户
    int addUser(UserBean userBean);

    //删除用户
    int dropUser(String id);

    //修改用户
    int modifyUser(UserBean userBean);

    //查询所有用户
    List<UserBean> queryAllUser();
}

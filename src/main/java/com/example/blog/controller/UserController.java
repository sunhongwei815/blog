package com.example.blog.controller;

import com.example.blog.bean.UserBean;
import com.example.blog.service.UserService;
import com.example.blog.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:Sun Hongwei
 * @2020/2/19 上午12:20
 * File Description：
 */

@Controller
public class UserController {

    private UserService userService;

    @RequestMapping("/getuserlist")
    public List<UserBean> getUserList()
    {
        return userService.queryAllUser();
    }
}

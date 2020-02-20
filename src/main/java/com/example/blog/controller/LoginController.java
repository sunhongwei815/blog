package com.example.blog.controller;

import com.example.blog.bean.UserBean;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:Sun Hongwei
 * @2020/2/18 下午9:17
 * File Description：
 */

@Controller
public class LoginController {

    //Service注入Web层
    @Autowired
    UserService userService;
    @RequestMapping(value="/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value="/loginIn", method = RequestMethod.POST)
    @ResponseBody
    public String login(String name, String password){
        int result;
        UserBean userBean=userService.loginIn(name,password);
        if(userBean==null){
            return "fail";
        }else{
            return "success";
        }
    }



}

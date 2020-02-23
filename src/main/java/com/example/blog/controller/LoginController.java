package com.example.blog.controller;

import com.example.blog.bean.UserBean;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/loginIn")
    @ResponseBody
    public Map loginIn(String name, String password){
        Map<String,String> map = new HashMap<String,String>();
        UserBean userBean=userService.loginIn(name,password);
        if(userBean==null){
            map.put("msg","登录失败");
        }else{
            map.put("msg","登录成功");
        }
        return map;
    }



}

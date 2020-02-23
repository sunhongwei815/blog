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

    @RequestMapping(value="/demo")
    public String show2(){
        return "demo";
    }

    @RequestMapping("/loginIn")
    @ResponseBody
    public Object loginIn(String name, String password){
        Map<String,String> map = new HashMap<String,String>();
        UserBean userBean=userService.loginIn(name,password);
       // System.out.println(userBean.getName()+" : "+userBean.getPassword());
        if(userBean == null){
            map.put("msg","fail");
        }else{
            map.put("msg","success");
        }
        System.out.println(map.get("msg"));
        return map;
    }



}

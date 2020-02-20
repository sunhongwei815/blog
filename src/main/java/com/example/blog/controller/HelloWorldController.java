package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Sun Hongwei
 * @2020/2/18 下午7:02
 * File Description：
 */



@Controller
public class HelloWorldController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}

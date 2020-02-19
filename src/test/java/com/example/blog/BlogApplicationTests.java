package com.example.blog;

import com.example.blog.bean.UserBean;
import com.example.blog.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BlogApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        UserBean userBean = userService.loginIn("a","a");
        System.out.println("该用户ID为：");
        System.out.println(userBean.getId());
    }

}

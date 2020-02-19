package com.example.blog.serviceImpl;

import com.example.blog.bean.UserBean;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Sun Hongwei
 * @2020/2/18 下午9:08
 * File Description：
 */
@Service
public class UserServiceImpl implements UserService {

    //Dao注入到Services层
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserBean loginIn(String name, String password){
        return userMapper.getInfo(name,password);
    }

    @Override
    public List<UserBean> getUserList(){
        try {
            List<UserBean> users = userMapper.getUserList();
            return users;
        }catch (Exception e){
            throw e;
        }
    }
}

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

    /**
     * 登录验证
     * @param name
     * @param password
     * @return
     */
    @Override
    public UserBean loginIn(String name, String password){
        try{
            UserBean userBean=userMapper.getInfo(name,password);
            return userBean;
        }catch (Exception e) {
            throw e;
        }
    }


    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @Override
    public UserBean queryUserById(String id){
        try {
            UserBean userBean=userMapper.selectUserById(id);
            return userBean;
        }catch (Exception e){
            throw e;
        }
    }


    /**
     * 新增用户
     * @param userBean
     * @return
     */
    @Override
    public int addUser(UserBean userBean){
        try{
            int aFlag=userMapper.insertUser(userBean);
            return aFlag;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
     @Override
     public int dropUser(String id){
         try{
             int dFlag=userMapper.deleteUser(id);
             return dFlag;
         }catch (Exception e){
             throw e;
         }
     }



    /**
     * 修改用户信息
     * remark：实际上还是根据用户ID修改用户信息
     * @param userBean
     * @return
     */
    @Override
    public int modifyUser(UserBean userBean){
        try{
            int mFlag=userMapper.updateUser(userBean);
            return mFlag;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserBean> queryAllUser(){
        try {
            List<UserBean> users = userMapper.getAllUser();
            return users;
        }catch (Exception e){
            throw e;
        }
    }
}

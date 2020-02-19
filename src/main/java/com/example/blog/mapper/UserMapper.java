package com.example.blog.mapper;
import com.example.blog.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author:Sun Hongwei
 * @2020/2/18 下午9:03
 * File Description：
 */

@Component
public interface UserMapper {

    //登录时验证信息
    UserBean getInfo(String name,String password);

    //根据ID查询用户信息
    UserBean selectUserById(String id);

    //增加新的用户
    int insertUser(UserBean userBean);

    //删除用户
    int deleteUser(String id);

    //修改用户
    int updateUser(UserBean userBean);

    //获取所有用户
    List<UserBean> getAllUser();

}

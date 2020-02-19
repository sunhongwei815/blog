package com.example.blog.redis;

/**
 * @author:Sun Hongwei
 * @2020/2/20 上午1:09
 * File Description：
 */
public interface RedisService {

    //判断key是否存在
    Boolean hasKey(String key);
}

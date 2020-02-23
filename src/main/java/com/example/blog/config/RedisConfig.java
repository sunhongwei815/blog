package com.example.blog.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author:Sun Hongwei
 * @2020/2/23 下午9:33
 * File Description：redis配置类
 */


@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * redistemplate相关配置
     * @param factory
     * @return
     */
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){

        RedisTemplate<String,Object> template=new RedisTemplate<>();
        //配置连接工厂
        template.setConnectionFactory(factory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value（默认使用JDK序列化方式）
        Jackson2JsonRedisSerializer jacksonSerial=new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om=new ObjectMapper();
        //制定要序列化的域，filed,get和set,以及修饰符范围，Any包括public和private
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        jacksonSerial.setObjectMapper(om);

        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        //值采用json序列化
        template.setValueSerializer(jacksonSerial);

        //设置hashkey和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSerial);

        template.afterPropertiesSet();

        return template;
    }

}

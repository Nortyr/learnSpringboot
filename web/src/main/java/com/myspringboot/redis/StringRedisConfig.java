package com.myspringboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @Auther: 陈晖
 * @Date:2019/1/17 0017
 * @Descroption:
 */

//@Configuration
@Configuration
public class StringRedisConfig {
    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }
//另一种设置序列化的方式，application.properties使用后加载
    private void initRedisTemplate() {
        RedisSerializer stringSerializer=redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }

////spring使用的方式
//    @Autowired
//    private RedisConnectionFactory connectionFactory;
//
//    @Bean("redisTemplate")
//    public RedisTemplate<Object,Object> initRedisTemplate(){
//        RedisTemplate<Object,Object> redisTemplate=new RedisTemplate<>();
//        RedisSerializer stringRedisSerializer=redisTemplate.getStringSerializer();
//        //修改序列化方式
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashValueSerializer(stringRedisSerializer);
//        //必须注入连接方式
//        redisTemplate.setConnectionFactory(connectionFactory);
//        return redisTemplate;
//    }

}

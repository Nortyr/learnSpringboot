package com.myspringboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 陈晖
 * @Date:2019/1/19 0019
 * @Descroption:
 */

//@Component
public class TestLua {
//    @Autowired
//    private RedisTemplate redisTemplate;
//    public void test(){
//        //p156
//        DefaultRedisScript<String> rs=new DefaultRedisScript<String>();
//        //设置脚本
//        rs.setScriptText("return 'Hello Redis'");
//        rs.setResultType(String.class);
//        RedisSerializer<String> stringSerializer=redisTemplate.getStringSerializer();
//        String str=(String)redisTemplate.execute(rs,stringSerializer,stringSerializer,null);
////        Map<String,Object> map=new HashMap<>();
//
//
//
//    }

}

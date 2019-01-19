package com.myspringboot.redis;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 陈晖
 * @Date:2019/1/16 0016
 * @Descroption:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class myRedisTest {

    @Autowired
    RedisUtil redisUtil;
    @Test
    public void testRedis(){
        boolean b=redisUtil.set("校长2","小王");
        System.out.println(b);
    }
    @Test
    public void testGet(){
        Object obj=redisUtil.get("校长1");
        System.out.println(obj);
    }
    @Test
    public void testSet1(){
        boolean b=redisUtil.set1("aaa","bbbb");
        System.out.println(b);
    }
    @Test
    public void testSet2(){
        boolean b=redisUtil.set2();
        System.out.println(b);
    }
    @Test
    public void testGet2(){
        redisUtil.get2();
    }
    @Test
    public void testSet3(){
        redisUtil.set3();
    }
    @Test
    public void testSet4(){
        redisUtil.set4();
    }
    @Test
    public void testSet5(){
        redisUtil.set5();
    }
    @Test
    public void testSet6(){
        redisUtil.set6();
    }
}

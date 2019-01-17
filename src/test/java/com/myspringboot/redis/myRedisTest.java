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
        boolean b=redisUtil.set("校长","小王");
        System.out.println(b);
    }
}

package com.myspringboot.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther: 陈晖
 * @Date:2019/1/17 0017
 * @Descroption:
 */

@Component
@Data
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}

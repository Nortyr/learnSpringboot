package com.myspringboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * @Auther: 陈晖
 * @Date:2019/1/19 0019
 * @Descroption:
 */

@Configuration
public class MyRedisCache {
    @Autowired
    private RedisConnectionFactory connectionFactory;
    //自定义的缓存管理器
    @Bean(name="redisCacheManager")
    public RedisCacheManager initRedisCacheManager(){
        //Redis加锁的写入器
        RedisCacheWriter writer=RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        //启动Redis缓存的默认设置
        RedisCacheConfiguration config=RedisCacheConfiguration.defaultCacheConfig();
        //设置jdk序列化器
        config=config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer()));
        //禁用前缀
        config=config.disableKeyPrefix();
        config=config.entryTtl(Duration.ofMinutes(10));
        RedisCacheManager redisCacheManager=new RedisCacheManager(writer,config);
        return redisCacheManager;



    }
}

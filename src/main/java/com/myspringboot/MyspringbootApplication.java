package com.myspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @PropertySource(value = {"classpath:xxx.properties"},ignoreResourceNotFound = true)
 * 扫描这个路径下的自定义properties，ignoreResourceNotFound:找不到就忽略掉
 *
 * @ImportResource(value = {"classpath:myxml.xml"})
 * 扫描这个路径下的xml
 */
@SpringBootApplication
//@EnableAspectJAutoProxy
//@PropertySource(value = {"classpath:xxx.properties"},ignoreResourceNotFound = true)
//@ImportResource(value = {"classpath:myxml.xml"})
//使用缓存管理器
@EnableCaching
public class MyspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }

}


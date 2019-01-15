package com.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

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
public class MyspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }

}


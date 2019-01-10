package com.myspringboot.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: 陈晖
 * @Date:2019/1/10 0010
 * @Descroption:
 */

/*
    @Component
    将这个类扫描进IoC
    @ComponentScan
    将这个类及其同级目录及其子目录扫描进IoC
    @Configuration
    代表这个类是Java配置类
    @Bean（卸载方法上）
    将这个方法返回的POJO装配到IoC中
 */
@Component
@Data
public class ComponentDemo {

    /*
    给属性附上初始值
    */
    @Value("1")
    private Integer id;
    @Value("username")
    private String name;

}

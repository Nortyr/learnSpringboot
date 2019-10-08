package com.myspringboot.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
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
        @ComponentScan(basePackages = {""})扫描制定目录
        @ComponentScan(basePackages = {""},excludeFilters = {@ComponentScan.Filter(classes = {Service.class})})
        不扫描某个包下带@Service的注解   includeFilters和excludeFilters里面用@Filter（这个相当于一个条件，正则）
        @ComponentScan(basePackages = {""},excludeFilters = {@ComponentScan.Filter(classes = {Service.class})}，lazyInit=true)
        lazyInit开启延迟加载
    @Configuration
    代表这个类是Java配置类
    @Bean（写在方法上）
    将这个方法返回的POJO装配到IoC中

    @Qualifier("dog")
    写autoWired下面，指定要导入那个bean，或者给bean上+@primary，IoC会优先招这个，但多个有@Primary就不管用

    @AutoWired
    好像不能用在方法上

    @Test 方法不能带参数

    @Conditional 和 @Condition 不清楚

 */
//@ComponentScan(basePackages = {""},excludeFilters = {@ComponentScan.Filter(classes = {})})
@Component
@Data
//没此用这个bean就创一个新的实例
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ComponentDemo {

    /*
    给属性附上初始值
    */
    @Value("1")
    private Integer id;
    @Value("username")
    private String name;

}

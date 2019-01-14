package com.myspringboot;

import com.myspringboot.annotation.ComponentDemo;
import com.myspringboot.annotation.YmlProperties;
import com.myspringboot.annotation.animal.Animal;
import com.myspringboot.aop_1.HelloService;
import com.myspringboot.aop_1.impl.HelloServiceImpl;
import com.myspringboot.aop_1.interceptor.MyInterceptor;
import com.myspringboot.aop_1.proxy.ProxyBean;
import com.myspringboot.aop_2.service.MyService;
import com.myspringboot.aop_3.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyspringbootApplicationTests {
    @Autowired
    ComponentDemo componentDemo;
    @Autowired
    private MyService myService;

    @Autowired(required = false)

    @Qualifier("dog")
    Animal animal;
//    Animal dog;

    @Autowired
    YmlProperties ymlProperties1;

    @Autowired
    YmlProperties ymlProperties;
    @Test
    public void contextLoads() {
    }

    @Test
    public void componentDemo() {
        System.out.println(componentDemo);

    }

    @Test

    public void autoWiredDemo(){
        System.out.println(animal.getClass().toString());
       ;
    }

    @Test
    public void PropertiesDemo(){
        System.out.println(ymlProperties.getPort());
    }
    @Test
    public void PropertiesDemo1(){
        System.out.println(ymlProperties1.getPort());
    }

    @Test
    public void testAop1(){
        HelloService helloService=new HelloServiceImpl();
        HelloService proxy=(HelloService) ProxyBean.getProxyBean(helloService,new MyInterceptor());
        proxy.sayHello("zhangsan");
        System.out.println("------------------------------------------------");
        proxy.sayHello(null);
    }

    @Test
    public void testAop2() {
        myService.sayHello();
    }

    @Test
    public void testAop3() {
        Skill skill=(Skill) myService;
        skill.skill();
        ((Skill) myService).skill();
    }

}


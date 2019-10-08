package com.myspringboot.mvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 陈晖
 * @Date:2019/1/29 0029
 * @Descroption:
 */

@Aspect
@Configuration
public class MyAop33 {
    @Pointcut("execution(* com.myspringboot.mvc.controller.MyController11.*(..))")
    public void myPointCut(){}

    @Before(value = "myPointCut()")
    public void ceshiBefore(JoinPoint point) {
        System.out.println("before");
        Object[] objs=point.getArgs();
        for(Object obj:objs){

            System.out.println(obj);
        }
    }

}

package com.myspringboot.annotation1;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Auther: 陈晖
 * @Date:2019/4/1 0001
 * @Descroption:
 */

@Aspect
@Configuration
@Slf4j
public class MyAnnotationAop1 {
    @Pointcut("@annotation(com.myspringboot.annotation1.MyAnnotation1)")
    public void pointcut(){}

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("请求地址 : " + request.getRequestURL().toString());
        System.out.println(request.getRequestURL().toString());
        log.info("HTTP METHOD : " + request.getMethod());
        System.out.println(request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        System.out.println(request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        log.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

}

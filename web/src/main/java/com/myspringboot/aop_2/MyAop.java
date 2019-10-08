package com.myspringboot.aop_2;


import com.myspringboot.aop_2.service.impl.MyServiceImpl;
import com.myspringboot.aop_3.Skill;
import com.myspringboot.aop_3.impl.SkillImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Auther: 陈晖
 * @Date:2019/1/3 0003
 * @Descroption:
 */

@Aspect
@Component
public class MyAop {
    /**
     * 第一个切入点
     */


    @Pointcut("execution(* com.myspringboot.aop_2.service.impl.MyServiceImpl.*(..))")
    public void logPointCut() {
    }

    @Before(value = "logPointCut()")
    public void ceshiBefore(JoinPoint point) {
        System.out.println("before");
    }
    @After(value = "logPointCut()")
    public void after(JoinPoint joinPoint)
    {
//        System.out.println(joinPoint.getArgs());
        System.out.println("after");
    }

    @Around(value = "logPointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before");
        proceedingJoinPoint.proceed();
        System.out.println("around after");
    }



    }

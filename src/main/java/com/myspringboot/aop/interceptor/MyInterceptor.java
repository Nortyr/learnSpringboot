package com.myspringboot.aop.interceptor;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: 陈晖
 * @Date:2019/1/12 0012
 * @Descroption:
 */


public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before ......");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after ......");
    }

    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println("around before ......");
        Object obj=invocation.proceed();
        System.out.println("around after ......");
        return null;
    }

    @Override
    public void afterReturning() {
        System.out.println("aroundReturning ......");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing ......");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}

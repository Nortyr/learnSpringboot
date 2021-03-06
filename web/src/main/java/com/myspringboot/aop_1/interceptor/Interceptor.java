package com.myspringboot.aop_1.interceptor;


import com.myspringboot.aop_1.invoke.Invocation;

/**
 * @Auther: 陈晖
 * @Date:2019/1/12 0012
 * @Descroption:
 */


public interface Interceptor {
    public boolean before();

    public void after();

    public Object around(Invocation invocation) throws Throwable;

    public void afterReturning();

    public void afterThrowing();

    boolean useAround();
}

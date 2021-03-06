package com.myspringboot.aop_1.proxy;

import com.myspringboot.aop_1.interceptor.Interceptor;
import com.myspringboot.aop_1.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: 陈晖
 * @Date:2019/1/12 0012
 * @Descroption:
 */


public class ProxyBean implements InvocationHandler {

    private Object target=null;
    private Interceptor interceptor=null;

    public static Object getProxyBean(Object target,Interceptor interceptor){
        ProxyBean proxyBean=new ProxyBean();
        proxyBean.target=target;
        proxyBean.interceptor=interceptor;
        Object proxy=Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),proxyBean);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag=false;
        Invocation invocation=new Invocation(args,method,target);
        Object retObj=null;
        try {
            if (this.interceptor.before()) {
                retObj = this.interceptor.around(invocation);
            }else {
                retObj= method.invoke(target,args);
            }
        }catch (Exception e){
            exceptionFlag=true;
        }
        this.interceptor.after();
        if(exceptionFlag){
            this.interceptor.afterThrowing();
        }else{
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}

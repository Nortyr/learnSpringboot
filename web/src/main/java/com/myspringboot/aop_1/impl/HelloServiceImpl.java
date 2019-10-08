package com.myspringboot.aop_1.impl;

import com.myspringboot.aop_1.HelloService;

/**
 * @Auther: 陈晖
 * @Date:2019/1/12 0012
 * @Descroption:
 */


public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println(name);
    }


}

package com.myspringboot.aop_2.service.impl;

import com.myspringboot.aop_2.service.MyService;
import org.springframework.stereotype.Service;

/**
 * @Auther: 陈晖
 * @Date:2019/1/14 0014
 * @Descroption:
 */

@Service
public class MyServiceImpl implements MyService {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}

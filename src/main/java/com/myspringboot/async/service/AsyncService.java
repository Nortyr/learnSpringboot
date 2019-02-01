package com.myspringboot.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Auther: 陈晖
 * @Date:2019/1/31 0031
 * @Descroption:
 */

@Service
public class AsyncService {
    @Async
    public void printA(){
        for(int i=0;i<100;i++) {
            System.out.println("["+Thread.currentThread().getName()+"]"+"+"+i);
        }
    }
    @Async
    public void printB(){
        for(int i=0;i<100;i++) {
            System.out.println("["+Thread.currentThread().getName()+"]"+"+"+i);
        }
    }
    @Async
    public void printC(){
        for(int i=0;i<100;i++) {
            System.out.println("["+Thread.currentThread().getName()+"]"+"+"+i);
        }
    }

}

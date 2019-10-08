package com.myspringboot.async.controller;

import com.myspringboot.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 陈晖
 * @Date:2019/1/31 0031
 * @Descroption:
 */

@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("helloAsync")
    public String helloRiTian(){
        System.out.println("["+Thread.currentThread().getName()+"]");
        asyncService.printA();
        asyncService.printB();
        asyncService.printC();
        return "ok";
    }

}

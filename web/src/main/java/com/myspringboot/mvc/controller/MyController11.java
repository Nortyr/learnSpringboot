package com.myspringboot.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

/**
 * @Auther: 陈晖
 * @Date:2019/1/26 0026
 * @Descroption:
 */

@Controller
public class MyController11 {

    @RequestMapping("/gotoTest")
    public String gotoTest(){
        System.out.println("111111111111111111");
        return "test.html";
    }

    @PostMapping(value = "/helloWorld")
    @ResponseBody
    public Integer hello( Integer id ){
        System.out.println("222222222222222222");
        return 1;
    }



}

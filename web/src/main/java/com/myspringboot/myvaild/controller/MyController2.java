package com.myspringboot.myvaild.controller;

import com.myspringboot.myvaild.valid.MyValid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 陈晖
 * @Date:2019/1/22 0022
 * @Descroption:
 */

@Controller
public class MyController2 {
    @InitBinder
    public  void initBinder(WebDataBinder binder){
        binder.setValidator(new MyValid());
        //下面这个 用的比较多，用于参数绑定
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }
}

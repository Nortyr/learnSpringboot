package com.myspringboot;

import com.myspringboot.annotation.ComponentDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyspringbootApplicationTests {
    @Autowired
    ComponentDemo componentDemo;
    @Test
    public void contextLoads() {
    }

    @Test

    public void componentDemo() {
        System.out.println(componentDemo);

    }

}


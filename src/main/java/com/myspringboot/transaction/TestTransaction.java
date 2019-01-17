package com.myspringboot.transaction;

import com.myspringboot.transaction.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 陈晖
 * @Date:2019/1/15 0015
 * @Descroption:
 */

@Service
public class TestTransaction {
    @Autowired
    PersonMapper personMapper;
    @Transactional(propagation = Propagation.SUPPORTS)
    public void Test1(){
//        List<Person>list= personMapper.selectAll();
        Test2();

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void Test2(){
        List<Person>list= personMapper.selectAll();

    }



}

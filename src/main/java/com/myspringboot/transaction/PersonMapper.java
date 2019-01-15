package com.myspringboot.transaction;


import com.myspringboot.transaction.po.Person;
import com.myspringboot.transaction.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: 陈晖
 * @Date:2019/1/15 0015
 * @Descroption:
 */

@Mapper
public interface PersonMapper extends MyMapper<Person>{

}

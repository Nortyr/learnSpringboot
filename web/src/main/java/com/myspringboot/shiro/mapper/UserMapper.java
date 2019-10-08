package com.myspringboot.shiro.mapper;



import com.myspringboot.shiro.MyMapper;
import com.myspringboot.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends MyMapper<User> {
}
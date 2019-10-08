package com.myspringboot.shiro.service;



import com.myspringboot.shiro.mapper.UserMapper;
import com.myspringboot.shiro.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 陈晖
 * @Date:2019/3/25 0025
 * @Descroption:
 */

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User login(User user){
        return userMapper.selectOne(user);
    }

}

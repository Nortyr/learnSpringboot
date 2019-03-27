package com.myspringboot.shiro;

import com.myspringboot.shiro.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: 陈晖
 * @Date:2019/3/25 0025
 * @Descroption:
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MyMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void test(){
        System.out.println(userMapper.selectAll());
    }

    SimpleAccountRealm simpleAccountRealm=new SimpleAccountRealm();

    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("MC","123456","admin");
    }

    @Test
    public void testAuthentication(){
        //构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        //主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("MC","123456");
        subject.login(token);
        System.out.println(subject.isAuthenticated());

        subject.checkRole("admin");

    }

}

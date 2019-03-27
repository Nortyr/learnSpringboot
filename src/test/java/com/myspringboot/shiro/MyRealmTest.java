package com.myspringboot.shiro;

import com.myspringboot.shiro.mapper.UserMapper;
import com.myspringboot.shiro.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Auther: 陈晖
 * @Date:2019/3/25 0025
 * @Descroption:
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MyRealmTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){
        MyShiroRealm myShiroRealm=new MyShiroRealm();
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myShiroRealm);

        //主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("xiao","123");
        subject.login(token);
        System.out.println(subject.isAuthenticated());
//        subject.checkRole("admin");
//        subject.checkPermission("user:add");
    }

    @Test
    public void test1(){
        User user=userMapper.selectByPrimaryKey("xiao");
        System.out.println(user);
    }
}

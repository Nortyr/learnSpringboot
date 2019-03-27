package com.myspringboot.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: 陈晖
 * @Date:2019/3/25 0025
 * @Descroption:
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MyShiroTest {

    @Test
    public void testAuthentication(){

        IniRealm iniRealm=new IniRealm("classpath:user.ini");
        //构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        //主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("MC","123456");
        subject.login(token);
        System.out.println(subject.isAuthenticated());

        subject.checkRole("admin");

        subject.checkPermission("user:delete");

    }
}

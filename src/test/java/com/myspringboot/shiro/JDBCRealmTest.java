package com.myspringboot.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @Auther: 陈晖
 * @Date:2019/3/25 0025
 * @Descroption:
 */


public class JDBCRealmTest {

    @Test
    public void test(){
        //构建SecurityManager环境
        DruidDataSource dataSource=new DruidDataSource();
        {
            dataSource.setUrl("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT%2B8");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
        }
        JdbcRealm jdbcRealm=new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        //主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("MC","123456");
        subject.login(token);
        System.out.println(subject.isAuthenticated());

//        subject.checkRole("admin");
//
//        subject.checkPermission("user:delete");
    }
}

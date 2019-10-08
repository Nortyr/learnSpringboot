package com.myspringboot.shiro;


import com.myspringboot.shiro.mapper.UserMapper;
import com.myspringboot.shiro.pojo.User;
import com.myspringboot.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: 陈晖
 * @Date:2019/3/25 0025
 * @Descroption:
 */


public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("-------------in 权限---------------------------");
        String username= (String) principalCollection.getPrimaryPrincipal();

        //获得角色数据
        Set<String> roles=getRolesByUserName(username);
        //获得权限数据
        Set<String> permission=getPermissionsByUserName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        //放入simpleAuthorizationInfo中
        simpleAuthorizationInfo.setStringPermissions(permission);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    private Set<String> getPermissionsByUserName(String username) {
        Set<String> sets=new HashSet<>();
        sets.add("admin:delete");
        sets.add("admin:add");
        return sets;
    }

    private Set<String> getRolesByUserName(String username) {
        Set<String> sets=new HashSet<>();
        sets.add("admin");
        sets.add("user");
        return sets;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("-------------in realm-----------------");
        //从主题传过来的认证信息中，获得用户名
        String userName=token.getPrincipal().toString();
        User user=userMapper.selectByPrimaryKey(userName);
        //通过用户名到数据库中获取凭证
//        String password=getPasswordByUserName(userName);
        if(user==null){
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(userName,user.getPassword(),"admin");
        return authenticationInfo;
    }
    private String getPasswordByUserName(String userName) {
        return "123456";
    }
}

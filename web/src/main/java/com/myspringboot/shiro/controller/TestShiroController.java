package com.myspringboot.shiro.controller;

import com.myspringboot.annotation1.MyAnnotation1;
import com.myspringboot.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 陈晖
 * @Date:2019/3/26 0026
 * @Descroption:
 */

@Controller
@ControllerAdvice
public class TestShiroController {
    @ExceptionHandler(value = UnauthorizedException.class)//处理访问方法时权限不足问题
    public String defaultErrorHandler(HttpServletRequest req, Exception e)  {
        return "redirect:error.html";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/subLogin")
    @MyAnnotation1
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password){
        System.out.println("--------------im in Controller-------------------");
        System.out.println(username+".....");
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return e.getMessage();
        } catch (IncorrectCredentialsException e) {
            return "账号或密码不正确";
        } catch (LockedAccountException e) {
            return "账号被锁定";
        } catch (AuthenticationException e) {
            return "账号验证失败";
        }
        return "登陆成功";
    }

    @RequestMapping("/myError")
    public String myError(){
        System.out.println("--------------im in error Controller-------------------");
        return "error.html";
    }

    @RequestMapping("/myIndex")
    public String index(){
        System.out.println("--------------im in index Controller-------------------");
        return "index1";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "ok";
    }

    @RequestMapping("/testRoles")
    @MyAnnotation1
    @RequiresRoles("admin")
    @ResponseBody
    public String testRoles(){

        return "admin success";
    }
    @RequestMapping("/testRoles1")
    @MyAnnotation1
    @RequiresRoles("admin1")
    @ResponseBody
    public String testRoles1(){
        return "admin1 success";
    }

    @RequestMapping("/testPermission")
    @MyAnnotation1
    @RequiresPermissions("admin:update")
    @ResponseBody
    public String testPermission(){

        return "update success";
    }

    @RequestMapping("/testPermission1")
    @MyAnnotation1
    @RequiresPermissions("admin:delete")
    @ResponseBody
    public String testPermission1(){
        return "add success ";
    }

}

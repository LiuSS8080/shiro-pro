package com.woniuxy;

import static org.junit.Assert.assertTrue;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AppTest 
{
    @Test
    public void testRole(){

        //创建SecurityManager工厂对象
        Factory<SecurityManager> factory= new IniSecurityManagerFactory("classpath:shiro.ini");
        //获取SecurityManager对象
        SecurityManager securtyManager=factory.getInstance();
        //通过SecurtiyUtils设置securtyManager
        SecurityUtils.setSecurityManager(securtyManager);
        //获取Subject主体对象
        Subject subject=SecurityUtils.getSubject();
        //创建UserPassword
        UsernamePasswordToken token=new UsernamePasswordToken("test","000000");
        //通过subject中的login完成登陆
        try {
            subject.login(token);
            if(subject.isAuthenticated()){
                System.out.println("登陆成功!");
                if(subject.hasRole("admin")){
                    System.out.println("拥有admin角色");
                }else{
                    System.out.println("不拥有admin角色");
                }
                if(subject.isPermitted("add")){
                    System.out.println("拥有增加的权限");
                }else{
                    System.out.println("不拥有增加的权限");
                }
                if(subject.isPermitted("delete")){
                    System.out.println("拥有的权限");
                }else{
                    System.out.println("不拥有删除的权限");
                }
                if(subject.isPermittedAll("add","search")) {
                    System.out.println("拥有add和search权限");
                }else{
                    System.out.println("不拥有add和search权限");
                }

            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登陆失败！");
        }
        subject.logout();

    }
    @Test
    public void testHelloShiro()
    {
        //创建SecurityManager工厂对象
        Factory<SecurityManager> factory= new IniSecurityManagerFactory("classpath:shiro.ini");
        //获取SecurityManager对象
        SecurityManager securtyManager=factory.getInstance();
        //通过SecurtiyUtils设置securtyManager
        SecurityUtils.setSecurityManager(securtyManager);
        //获取Subject主体对象
        Subject subject=SecurityUtils.getSubject();
        //创建UserPassword
        UsernamePasswordToken token=new UsernamePasswordToken("giles","123456");
        //通过subject中的login完成登陆
        try {
            subject.login(token);
            if(subject.isAuthenticated()){
                System.out.println("登陆成功!");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登陆失败！");
        }

    }
}

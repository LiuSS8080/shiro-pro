package com.woniuxy.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {
    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String userName=(String)authenticationToken.getPrincipal();
        //获取密码
        String password=new String((char[]) authenticationToken.getCredentials());
        if(!"giles".equals(userName)){
            throw new UnknownAccountException("没有该账户！");
        }
        if(!"123456".equals(password)){
            throw new IncorrectCredentialsException("密码有误！");
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(userName,password,getName());
       return info;
    }
}

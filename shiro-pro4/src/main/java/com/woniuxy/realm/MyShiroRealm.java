package com.woniuxy.realm;

import com.woniuxy.service.UserService;
import com.woniuxy.service.impl.UserServiceImpl;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {
    private UserService userService;
    public MyShiroRealm(){
        userService=new UserServiceImpl();
    }
    //授权的时候会被调用
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("*************授权的时候会被调用*************************");
        //获取用户名
        String userName=(String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> roleNames=userService.getRolesByUserName(userName);
        Set<String> permissionNames=userService.getPermissionsByUserName(userName);
        info.addRoles(roleNames);
        info.setStringPermissions(permissionNames);
        return info;
    }
    //认证的时候会被调用
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("*************认证的时候会被调用*************************");
        //获取用户名
        String userName=(String)authenticationToken.getPrincipal();
        //通过service中的方法来查询密码
        String password=userService.getPasswordByUserName(userName);
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(userName,password,getName());
        return info;
    }
}

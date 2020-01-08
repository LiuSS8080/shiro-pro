package com.woniuxy;

import static org.junit.Assert.assertTrue;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class AppTest 
{
    /**
     * 自定义数据库表
     */
    @Test
    public void testJdbcRealm2()
    {
        //创建JdbcRealm对象
        JdbcRealm jdbcRealm=new JdbcRealm();
        //创建DataSource
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test_shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        jdbcRealm.setDataSource(dataSource);
        //默认情况下，不能检测权限的，如果要去检测必须要设置如下的方式
        jdbcRealm.setPermissionsLookupEnabled(true);
        String sql="select password from t_user where user_name = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        String sql2="select role_name from t_user_role where user_name = ?";
        jdbcRealm.setUserRolesQuery(sql2);

        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        securityManager.setRealm(jdbcRealm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("jerry","0000");
        try {
            subject.login(token);
            if(subject.isAuthenticated())
            {
                System.out.println("登陆成功");
            }
            subject.checkRole("admin");
            subject.checkPermission("user:select");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testJdbcRealm()
    {
        //创建JdbcRealm对象
        JdbcRealm jdbcRealm=new JdbcRealm();
        //创建DataSource
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test_shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        jdbcRealm.setDataSource(dataSource);
        //默认情况下，不能检测权限的，如果要去检测必须要设置如下的方式
        jdbcRealm.setPermissionsLookupEnabled(true);
        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        securityManager.setRealm(jdbcRealm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("giles","1234");
        try {
            subject.login(token);
            if(subject.isAuthenticated())
            {
                System.out.println("登陆成功");
            }
            subject.checkRole("admin");
            subject.checkPermission("user:select");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


    }
}

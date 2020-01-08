package com.woniuxy;

import static org.junit.Assert.assertTrue;

import com.woniuxy.dao.UserDao;
import com.woniuxy.realm.MyShiroRealm;
import com.woniuxy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testAuthcation(){
        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        securityManager.setRealm(new MyShiroRealm());
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("Giles","1234");
        try {
            subject.login(token);
            boolean flag=subject.isAuthenticated();
            if(flag){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
            //subject.checkRole("admin");
            //subject.checkRoles("admin","test");
            subject.checkPermissions("user:select","user:add","cus:dell");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void shouldAnswerWithTrue()
    {
        SqlSession sqlSession= MyBatisUtil.createSqlSession();
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        String password=userDao.getPasswordByUserName("Giles");
        System.out.println("password:"+password);
    }
}

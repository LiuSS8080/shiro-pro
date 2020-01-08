package com.woniuxy.service.impl;

import com.woniuxy.dao.UserDao;
import com.woniuxy.service.UserService;
import com.woniuxy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Set;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(){
        SqlSession sqlSession= MyBatisUtil.createSqlSession();
        userDao=sqlSession.getMapper(UserDao.class);
    }
    @Override
    public String getPasswordByUserName(String userName) {
        return userDao.getPasswordByUserName(userName);
    }

    @Override
    public Set<String> getRolesByUserName(String userName) {
        return userDao.getRolesByUserName(userName);
    }

    @Override
    public Set<String> getPermissionsByUserName(String userName) {
        return this.userDao.getPermissionsByUserName(userName);
    }
}

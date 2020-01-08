package com.woniuxy.dao;

import com.woniuxy.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User getUserByUserName(String userName);
}

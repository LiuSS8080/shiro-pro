package com.woniuxy.service;

import com.woniuxy.pojo.User;

public interface UserService {
    public User getUserByUserName(String userName);
    public User getLogin(String name,String password);
}

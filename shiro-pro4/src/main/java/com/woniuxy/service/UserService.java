package com.woniuxy.service;

import java.util.Set;

public interface UserService {
    public String getPasswordByUserName(String userName);
    public Set<String> getRolesByUserName(String userName);
    public Set<String> getPermissionsByUserName(String userName);
}

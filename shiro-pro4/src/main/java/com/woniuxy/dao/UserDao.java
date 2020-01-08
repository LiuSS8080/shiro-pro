package com.woniuxy.dao;

import java.util.Set;

public interface UserDao {
    /**
     * 通过用户名查找密码
     * @param userName
     * @return
     */
    public String getPasswordByUserName(String userName);

    /**
     * 通过用户名查找角色集合
     * @param userName
     * @return
     */
    public Set<String> getRolesByUserName(String userName);

    /**
     * 通过用户名查找权限集合
     * @param userName
     * @return
     */
    public Set<String> getPermissionsByUserName(String userName);
}

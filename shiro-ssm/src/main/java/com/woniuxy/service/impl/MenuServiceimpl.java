package com.woniuxy.service.impl;

import com.woniuxy.dao.MenuDao;
import com.woniuxy.pojo.Menu;
import com.woniuxy.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceimpl implements IMenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenu() {
        return menuDao.getMenu();
    }
}

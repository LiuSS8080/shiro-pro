package com.woniuxy.dao;

import com.woniuxy.pojo.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuDao {
    public List<Menu> getMenu();
}

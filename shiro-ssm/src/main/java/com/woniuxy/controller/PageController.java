package com.woniuxy.controller;

import com.woniuxy.pojo.Menu;
import com.woniuxy.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private IMenuService menuService;

    @RequestMapping("indexMenu.html")
    @ResponseBody
    public List<Menu> indexMenu(){
        System.out.println("===========indexMenu.html=============");
        return menuService.getMenu();
    }

    @RequestMapping("index.html")
    public String index(){
        return "index";
    }
    @RequestMapping("error.html")
    public String error(){
        return "error";
    }
}

package com.woniuxy.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Menu implements Serializable {
    private Integer id;
    private String name;
    private Integer pid;
    private String icon;
    private Integer state;
    private String url;

}

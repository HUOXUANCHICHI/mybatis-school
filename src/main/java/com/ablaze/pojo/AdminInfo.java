package com.ablaze.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/10/12/8:44
 */
@Data
public class AdminInfo {
    private int id;
    private String name;
    //ofType=Functions 元素类型
    //property=fs
    private List<Functions> fs;
}

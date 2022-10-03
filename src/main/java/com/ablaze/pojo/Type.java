package com.ablaze.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/10/03/11:07
 */
@Data
public class Type {
    private Integer id;
    private String name;
    /**
     * 关联集合属性（一对多）
     */
    private List<ProductInfo> pis;
}

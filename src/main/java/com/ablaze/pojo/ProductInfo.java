package com.ablaze.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ablaze
 * @Date: 2022/10/03/11:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {
    private Integer id;
    private String code;
    private String name;
    /**
     * 关联属性
     */
    private Type type;
}

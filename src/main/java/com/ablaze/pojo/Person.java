package com.ablaze.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/11:09
 */

@Getter
@Setter
@ToString
public class Person {
    private int id;
    private String name;
    private int age;
    private String sex;
    /**
     * 关联属性
     */
    private IdCard idcard;
}

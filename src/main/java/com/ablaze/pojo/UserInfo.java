package com.ablaze.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author CHICHI
 */
@Getter
@Setter
@ToString
public class UserInfo implements Serializable {
    /**
     * id 主键
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 真名
     */
    private String realName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 日期
     */
    private String regDate;
    /**
     * 状态：0：禁用  1：启用
     */
    private Integer status;

    /**
     * 逻辑视图
     * @return 启用禁用
     */
    public String getStatusStr(){
        if (status == null){
            return "未知";
        }
        return status == 0 ? "禁用":"启用";
    }

}

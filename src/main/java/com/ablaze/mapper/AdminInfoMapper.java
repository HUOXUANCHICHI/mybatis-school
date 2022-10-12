package com.ablaze.mapper;

import com.ablaze.pojo.AdminInfo;

/**
 * @Author: ablaze
 * @Date: 2022/10/12/9:07
 */
public interface AdminInfoMapper {
    AdminInfo findAdminInfoById(int id);

    AdminInfo findAdminInfoById2(int id);
}

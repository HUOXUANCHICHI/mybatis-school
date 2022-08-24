package com.ablaze.service;

import com.ablaze.pojo.UserInfo;

public interface UserInfoService {
    /**
     * 根据id查询
     * @param id
     */
    UserInfo findUserInfoById(int id);
}

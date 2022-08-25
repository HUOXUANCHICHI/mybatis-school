package com.ablaze.service;

import com.ablaze.pojo.UserInfo;

/**
 * @author CHICHI
 */
public interface UserInfoService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserInfo findUserInfoById(int id);
}

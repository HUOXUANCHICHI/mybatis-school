package com.ablaze.mapper;

import com.ablaze.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserInfo findUserInfoById(int id);

    /**
     * 单/多条件模糊查询
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByCondition(UserInfo userInfo);

    /**
     * 条件动态查询
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByConditionSingle(UserInfo userInfo);

}

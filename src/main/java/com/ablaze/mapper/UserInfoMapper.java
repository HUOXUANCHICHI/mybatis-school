package com.ablaze.mapper;

import com.ablaze.pojo.UserInfo;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author CHICHI
 */
public interface UserInfoMapper {

    /**
     * 根据id查询 
     * @param id
     * @return
     */
    @Select("select * from user_info where id = #{id}")
    @ResultMap("userInfoResultMap")
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

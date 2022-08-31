package com.ablaze.mapper;

import com.ablaze.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

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
     * 单条件模糊查询（ByName）
     * @param userInfo
     * @return
     */
    @Select("select * from user_info where user_name like #{userName}")
    @ResultMap("userInfoResultMap")
    List<UserInfo> findUserInfoByName(UserInfo userInfo);

    /**
     * 多条件模糊查询
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

    /**
     * 添加数据
     * @param userInfo
     */
    @Insert("insert into user_info values (null,#{userName},#{password},#{realName},#{sex},#{address},#{email},#{regDate},#{status})")
    void add(UserInfo userInfo);

    /**
     * 修改
     * @param userInfo
     * @return
     */
    @Update("update user_info set user_name = #{userName}," +
            "password = #{password}," +
            "real_name = #{realName}," +
            "sex = #{sex}," +
            "address = #{address}," +
            "email = #{email}," +
            "regDate = #{regDate}," +
            "status = #{status} where id = #{id}")
    int update(UserInfo userInfo);

    /**
     * 根据id删除
     * @param id
     */
    @Delete("delete from user_info where id = #{id}")
    void deleteById(int id);
}

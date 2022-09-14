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
     *
     * @param uid
     * @return
     */
    //@Select("select * from user_info where id = #{id}")
    //@ResultMap("userInfoResultMap")
    UserInfo findUserInfoById(int uid);

    /**
     * 单条件模糊查询（ByName）
     *
     * @param userInfo
     * @return
     */
    @Select("select * from user_info where userName like #{uname}")
    @ResultMap("userInfoResultMap")
    List<UserInfo> findUserInfoByName(UserInfo userInfo);

    /**
     * 多条件模糊查询
     *
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByCondition(UserInfo userInfo);

    /**
     *
     * 根据用户姓名和性别进行查询
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByNameAndSex(UserInfo userInfo);

    /**
     * 条件动态查询
     *
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByConditionSingle(UserInfo userInfo);

    /**
     * 添加数据
     *
     * @param userInfo
     */
    //@Insert("insert into user_info values (null,#{uname},#{upass},#{realName},#{sex},#{address},#{email},#{regDate},#{status})")
    void addUserInfo(UserInfo userInfo);

    /**
     * 修改
     *
     * @param userInfo
     * @return
     */
    /*@Update("update user_info set userName = #{uname}," +
            "password = #{upass}," +
            "realName = #{realName}," +
            "sex = #{sex}," +
            "address = #{address}," +
            "email = #{email}," +
            "regDate = #{regDate}," +
            "status = #{status} where id = #{uid}")*/
    int updateUserInfo(UserInfo userInfo);

    /**
     * 根据id删除
     *
     * @param uid
     */
    @Delete("delete from user_info where id = #{uid}")
    void deleteUserInfoById(int uid);
}

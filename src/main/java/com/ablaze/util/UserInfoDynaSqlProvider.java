package com.ablaze.util;

import com.ablaze.pojo.UserInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Author: ablaze
 * @Date: 2022/10/24/10:55
 */
public class UserInfoDynaSqlProvider {

    public String selectWithParam(final Map<String, Object> param) {
        return new SQL() {
            {
                SELECT("*");
                FROM("user_info");
                if (param.get("id") != null) {
                    WHERE("id=#{id}");
                }
                if (param.get("userName") != null) {
                    WHERE("userName=#{userName}");
                }
                if (param.get("password") != null) {
                    WHERE("password=#{password}");
                }
            }

        }.toString();
    }

    public String insertUserInfo(final UserInfo userInfo) {
        return new SQL() {
            {
                INSERT_INTO("user_info");
                if (userInfo.getUname() != null) {
                    VALUES("userName", "#{uname}");
                }
                if (userInfo.getUpass() != null) {
                    VALUES("password", "#{upass}");
                }
            }

        }.toString();
    }
}

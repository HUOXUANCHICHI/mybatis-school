package com.ablaze.mapper;

import com.ablaze.pojo.AdminInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: ablaze
 * @Date: 2022/10/12/9:07
 */
public interface AdminInfoMapper {
    /**
     * 查 多对多 嵌套查询
     * @param id
     * @return
     */
    @Select("select * from admin_info as a where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "fs", many = @Many(select = "com.ablaze.mapper.FunctionsMapper.findFunctionsByAid"))
    })
    AdminInfo findAdminInfoById(int id);

    /**
     * 查 多对多 嵌套结果
     * @param id
     * @return
     */
    AdminInfo findAdminInfoById2(int id);
}

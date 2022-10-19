package com.ablaze.mapper;

import com.ablaze.pojo.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/11:23
 */
public interface PersonMapper {

    /**
     * 一对一 嵌套查询 根据id查询Person全部
     *
     * @param id
     * @return
     */
    @Select("select * from person where id = #{id}")
    @Results({
            @Result(column = "cid",
                    property = "idcard",
                    one = @One(select = "com.ablaze.mapper.IdCardMapper.findIdCardById"))
    })
    Person findPersonById(int id);

    /**
     * 一对一 嵌套查询结果 根据personId查询person全部信息和idcard全部信息
     *
     * @param id
     * @return
     */
    Person findPersonAndIdCardByPersonId(int id);
}

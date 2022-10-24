package com.ablaze.mapper;

import com.ablaze.pojo.Functions;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/10/12/9:15
 */
public interface FunctionsMapper {
    /**
     * 多对多 嵌套查询
     * @param id
     * @return
     */
    @Select("select * from functions as f where id in (select fid from powers where aid = #{id})")
    List<Functions> findFunctionsByAid(int id);
}

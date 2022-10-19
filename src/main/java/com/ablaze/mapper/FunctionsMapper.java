package com.ablaze.mapper;

import com.ablaze.pojo.Functions;

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
    List<Functions> findFunctionsByAid(int id);
}

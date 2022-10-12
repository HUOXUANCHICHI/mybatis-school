package com.ablaze.mapper;

import com.ablaze.pojo.Functions;

/**
 * @Author: ablaze
 * @Date: 2022/10/12/9:15
 */
public interface FunctionsMapper {
    Functions findFunctionsByAid(int id);
}

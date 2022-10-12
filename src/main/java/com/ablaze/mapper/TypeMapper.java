package com.ablaze.mapper;

import com.ablaze.pojo.Type;

/**
 * @Author: ablaze
 * @Date: 2022/10/03/11:15
 */
public interface TypeMapper {

    /**
     * 根据类型id查询全部
     * @param id
     * @return
     */
    Type findTypeById(int id);

    void addType(Type type);

    void deleteTypeById(int id);
}

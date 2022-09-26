package com.ablaze.mapper;

import com.ablaze.pojo.Person;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/11:23
 */
public interface PersonMapper {

    /**
     * 根据id查询Person全部
     * @param id
     * @return
     */
    Person findPersonById(int id);
}

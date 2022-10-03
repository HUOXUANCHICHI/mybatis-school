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

    /**
     * 根据personId查询person全部信息和idcard全部信息
     * @param id
     * @return
     */
    Person findPersonAndIdCardByPersonId(int id);
}

package com.ablaze.mapper;

import com.ablaze.pojo.AdminInfo;

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
    AdminInfo findAdminInfoById(int id);

    /**
     * 查 多对多 嵌套结果
     * @param id
     * @return
     */
    AdminInfo findAdminInfoById2(int id);
}

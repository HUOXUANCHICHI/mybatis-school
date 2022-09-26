package com.ablaze.mapper;

import com.ablaze.pojo.IdCard;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/11:18
 */
public interface IdCardMapper {

    /**
     * 根据id查找IdCard全部
     * @param id
     * @return
     */
    IdCard findIdCardById(int id);

}

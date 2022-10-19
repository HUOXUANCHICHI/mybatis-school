package com.ablaze.mapper;

import com.ablaze.pojo.IdCard;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/11:18
 */
public interface IdCardMapper {

    /**
     * 一对一 嵌套查询 根据id查找IdCard全部
     * @param id
     * @return
     */
    @Select("select * from idcard where id = #{id}")
    IdCard findIdCardById(int id);

}

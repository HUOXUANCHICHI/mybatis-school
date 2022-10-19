package com.ablaze.mapper;

import com.ablaze.pojo.Type;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: ablaze
 * @Date: 2022/10/03/11:15
 */
public interface TypeMapper {

    /**
     * 一对多 嵌套查询 根据类型id查询全部
     * @param id
     * @return
     */
    @Select("select * from type where id = #{id}")
    @Results({
            /*一致可省略*/
            /*@Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),*/
            @Result(column = "id",
                    property = "pis",
                    many = @Many(select = "com.ablaze.mapper.ProductInfoMapper.findProductInfoById"))
    })
    Type findTypeById(int id);

    /**
     * 一对多 嵌套查询结果
     * @param id
     * @return
     */
    Type findTypeById2(int id);

    /**
     * 一对多 数据插入
     * @param type
     */
    void addType(Type type);

    /**
     * 一对多 数据删除
     * @param id
     */
    void deleteTypeById(int id);

    /**
     * 一对一 嵌套查询
     * @param id
     * @return
     */
    @Select("select * from type where id = #{id}")
    Type findTypeByIdYY(int id);
}

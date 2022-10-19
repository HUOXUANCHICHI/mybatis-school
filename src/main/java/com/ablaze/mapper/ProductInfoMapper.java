package com.ablaze.mapper;

import com.ablaze.pojo.ProductInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: ablaze
 * @Date: 2022/10/03/11:19
 */
public interface ProductInfoMapper {

    /**
     * 一对多 嵌套查询 根据产品id查询全部
     * @param id
     * @return
     */
    @Select("select * from product_info where tid = #{id}")
    ProductInfo findProductInfoById(int id);

    /**
     * 一对多 数据插入
     * @param pi
     */
    void  addProductInfo(ProductInfo pi);

    /**
     * 一对多 数据删除（mysql妥协版）
     * @param id
     */
    void deleteProductInfoById(int id);

    /**
     * 一对一 嵌套查询
     * @param id
     * @return
     */
    @Select("select * from product_info where id = #{id}")
    @Results({
            @Result(column = "tid",
                    property = "type",
                    one = @One(select = "com.ablaze.mapper.TypeMapper.findTypeByIdYY"))
    })
    ProductInfo findProductInfoByIdYY(int id);
}

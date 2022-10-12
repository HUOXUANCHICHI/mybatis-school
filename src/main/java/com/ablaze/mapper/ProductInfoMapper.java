package com.ablaze.mapper;

import com.ablaze.pojo.ProductInfo;

/**
 * @Author: ablaze
 * @Date: 2022/10/03/11:19
 */
public interface ProductInfoMapper {

    /**
     * 根据产品id查询全部
     * @param id
     * @return
     */
    ProductInfo findProductInfoById(int id);

    void  addProductInfo(ProductInfo pi);

    void deleteProductInfoById(int id);
}

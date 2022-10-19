package com.ablaze.service;

import com.ablaze.mapper.*;
import com.ablaze.pojo.*;
import com.ablaze.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/11:35
 */
public class MyBatis02Test {

    /**
     * 1. 创建SqlSessionFactory 工厂对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Test
    public void testSelectIdCardById() {

        //接收参数
        int id = 1;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        IdCardMapper idCardMapper = sqlSession.getMapper(IdCardMapper.class);
        //4.执行方法
        IdCard idCardById = idCardMapper.findIdCardById(id);
        System.out.println(idCardById);
        //5.释放资源
        sqlSession.close();

    }

    //一对一 嵌套查询
    @Test
    public void testSelectPersonById() {

        //接收参数
        int id = 1;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        //4.执行方法
        Person personById = personMapper.findPersonById(id);
        System.out.println(personById);
        //5.释放资源
        sqlSession.close();

    }

    //一对一 嵌套查询结果
    @Test
    public void testFindPersonAndIdCardByPersonId() {

        //接收参数
        int id = 1;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        //4.执行方法
        Person personAndIdCardByPersonId = personMapper.findPersonAndIdCardByPersonId(id);
        System.out.println(personAndIdCardByPersonId);
        //5.释放资源
        sqlSession.close();

    }

    //一对多 嵌套查询
    @Test
    public void testFindTypeId() {

        //接收参数
        int id = 1;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        //4.执行方法
        Type typeById = typeMapper.findTypeById(id);
        System.out.println(typeById);
        //5.释放资源
        sqlSession.close();

    }

    //一对一 嵌套查询
    @Test
    public void testFindProductInfoByIdYY() {

        //接收参数
        int id = 1;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        ProductInfoMapper productInfoMapper = sqlSession.getMapper(ProductInfoMapper.class);
        //4.执行方法
        ProductInfo productInfo = productInfoMapper.findProductInfoByIdYY(id);
        System.out.println(productInfo);
        //5.释放资源
        sqlSession.close();

    }

    //一对多 嵌套查询结果
    @Test
    public void testFindTypeId2() {

        //接收参数
        int id = 1;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        //4.执行方法
        Type typeById = typeMapper.findTypeById2(id);
        System.out.println(typeById);
        //5.释放资源
        sqlSession.close();

    }

    //一对多 数据插入
    @Test
    public void addTypeTest(){
        //接收参数
        String name1 = "打印机";
        String name2 = "HP1306";
        String name3 = "HP11103";
        String code1 = "1111";
        String code2 = "2222";

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        ProductInfoMapper productInfoMapper = sqlSession.getMapper(ProductInfoMapper.class);
        //4.执行方法
        Type type = new Type();
        type.setName(name1);
        typeMapper.addType(type);
        ProductInfo p1 = new ProductInfo();
        ProductInfo p2 = new ProductInfo();
        p1.setCode(code1);
        p1.setName(name2);
        p2.setCode(code2);
        p2.setName(name3);
        p1.setType(type);
        p2.setType(type);
        productInfoMapper.addProductInfo(p1);
        productInfoMapper.addProductInfo(p2);
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void deleteTypeTest(){
        //接收参数
        int id = 8;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        //4.执行方法
        ProductInfoMapper productInfoMapper = sqlSession.getMapper(ProductInfoMapper.class);
        productInfoMapper.deleteProductInfoById(id);
        typeMapper.deleteTypeById(id);
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    //多对多查询 嵌套查询
    @Test
    public void findAdminInfoByIdTest() {
        //接收参数
        int id = 1;
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        AdminInfoMapper adminInfoMapper = sqlSession.getMapper(AdminInfoMapper.class);
        AdminInfo adminInfoById = adminInfoMapper.findAdminInfoById(id);
        System.out.println(adminInfoById);
        //5.释放资源
        sqlSession.close();
    }
    //多对多查询 嵌套查询结果
    @Test
    public void findAdminInfoByIdTest2() {
        //接收参数
        int id = 1;
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        AdminInfoMapper adminInfoMapper = sqlSession.getMapper(AdminInfoMapper.class);
        AdminInfo adminInfoById = adminInfoMapper.findAdminInfoById2(id);
        System.out.println(adminInfoById);
        //5.释放资源
        sqlSession.close();
    }

}

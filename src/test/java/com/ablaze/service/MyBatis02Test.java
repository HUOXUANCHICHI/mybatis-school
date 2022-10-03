package com.ablaze.service;

import com.ablaze.mapper.IdCardMapper;
import com.ablaze.mapper.PersonMapper;
import com.ablaze.mapper.TypeMapper;
import com.ablaze.pojo.IdCard;
import com.ablaze.pojo.Person;
import com.ablaze.pojo.Type;
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
}

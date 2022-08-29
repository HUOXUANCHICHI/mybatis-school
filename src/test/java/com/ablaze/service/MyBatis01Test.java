package com.ablaze.service;

import com.ablaze.mapper.UserInfoMapper;
import com.ablaze.pojo.UserInfo;
import com.ablaze.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MyBatis01Test {
    /**
     * 1. 创建SqlSessionFactory 工厂对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Test
    public void testSelectById() throws IOException {

        //接收参数
        int id = 2;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

        //4.执行方法
        UserInfo userInfo = userInfoMapper.findUserInfoById(id);
        System.out.println(userInfo);
        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void testFindUserInfoByName() {
        //单条件模糊查询
        //接收参数
        String userName = "i";

        //处理参数
        userName = "%" + userName + "%";

        //封装对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = userInfoMapper.selectByCondition(userInfo);
//        System.out.println(userInfos);
        userInfos.forEach(System.out::println);
        //5.释放资源
        sqlSession.close();
    }

    /**
     * 多条件模糊查询
     *
     * @throws IOException
     */
    @Test
    public void testSelectByCondition() {

        //接收参数
        int status = 1;
        String userName = "1";
        String realName = "1";

        //处理参数
        userName = "%" + userName + "%";
        realName = "%" + realName + "%";
        //封装对象
        UserInfo userInfo = new UserInfo();
        userInfo.setStatus(status);
        userInfo.setUserName(userName);
        userInfo.setRealName(realName);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = userInfoMapper.selectByCondition(userInfo);
        System.out.println(userInfos);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() {
        //接收参数
        int status = 1;
        String userName = "chichi";
        String realName = "赤赤";

        //处理参数
        userName = "%" + userName + "%";
        realName = "%" + realName + "%";
        //封装对象
        UserInfo userInfo = new UserInfo();
        userInfo.setStatus(status);
        userInfo.setUserName(userName);
        userInfo.setRealName(realName);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = userInfoMapper.selectByCondition(userInfo);
        System.out.println(userInfos);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() {
        int status = 1;
        String userName = "chichi4";
        String password = "4";
        String realName = "赤赤4";
        String sex = "0";
        String address = "11";
        String email = "11";
//        Date regDate = "1970-01-09";
//        Date regDate = new Date();
//        System.out.println(regDate.toString());
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setRealName(realName);
        userInfo.setSex(sex);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
//        userInfo.setRegDate(regDate);
        userInfo.setStatus(status);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        userInfoMapper.add(userInfo);
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void testUpdate() {
        //接收参数
        int status = 1;
        String userName = "chichi4";
        String password = "4";
        String realName = "赤赤4";
        String sex = "0";
        String address = "11";
        String email = "11";
//        Date regDate = "1970-01-09";
        int id = 4;

        //封装对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setRealName(realName);
        userInfo.setSex(sex);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
//        userInfo.setRegDate(regDate);
        userInfo.setStatus(status);
        userInfo.setId(id);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        int count = userInfoMapper.update(userInfo);
        System.out.println(count);
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() {
        //接收参数
        int id = 5; //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        userInfoMapper.deleteById(id);

        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

}

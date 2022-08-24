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
        UserInfoMapper UserInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

        //4.执行方法
        UserInfo userInfo = UserInfoMapper.findUserInfoById(id);
        System.out.println(userInfo);
        //5.释放资源
        sqlSession.close();

    }

    /**
     * 单/多条件模糊查询
     * @throws IOException
     */
    @Test
    public void testSelectByCondition() {

/*      //单条件模糊查询
        //接收参数
        String userName = "1";

        //处理参数
        userName = "%" + userName + "%";

        //封装对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
*/

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
        UserInfoMapper UserInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = UserInfoMapper.selectByCondition(userInfo);
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
        UserInfoMapper UserInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = UserInfoMapper.selectByCondition(userInfo);
        System.out.println(userInfos);
        //5.释放资源
        sqlSession.close();
    }

}

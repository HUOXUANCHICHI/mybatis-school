package com.ablaze.service.impl;

import com.ablaze.mapper.UserInfoMapper;
import com.ablaze.pojo.UserInfo;
import com.ablaze.service.UserInfoService;
import com.ablaze.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserInfoServiceImpl implements UserInfoService {
    /**
     * 1. 创建SqlSessionFactory 工厂对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public UserInfo findUserInfoById(int id) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserInfoMapper
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        //4. 调用方法
        UserInfo userInfos = mapper.findUserInfoById(id);
        //释放资源
        sqlSession.close();

        return userInfos;
    }
}

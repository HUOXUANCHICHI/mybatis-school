package com.ablaze.service;

import com.ablaze.mapper.UserInfoMapper;
import com.ablaze.pojo.UserInfo;
import com.ablaze.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyBatis01Test {
    /**
     * 1. 创建SqlSessionFactory 工厂对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //单表
    @Test
    public void testSelectUserInfoById() {

        //接收参数
        int uid = 2;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

        //4.执行方法
        UserInfo userInfo = userInfoMapper.findUserInfoById(uid);
        System.out.println(userInfo);
        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void testFindUserInfoByName() {
        //单条件模糊查询
        //接收参数
        String uname = "i";

        //处理参数
        /*uname = "%" + uname + "%";*/

        //封装对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUname(uname);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = userInfoMapper.findUserInfoByName(userInfo);
//        System.out.println(userInfos);
        userInfos.forEach(System.out::println);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() {

        //接收参数
        int status = 1;
        String uname = "i";
        String realName = "赤";

        //处理参数
/*        uname = "%" + uname + "%";
        realName = "%" + realName + "%";*/
        //封装对象
        UserInfo userInfo = new UserInfo();
        userInfo.setStatus(status);
        userInfo.setUname(uname);
        userInfo.setRealName(realName);

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
    @Test
    public void testSelectByCond() {

        //接收参数
        String userName = "chichi";
        String password = "111";

        //封装对象
        HashMap<String, Object> param = new HashMap<>();
        param.put("userName",userName);
        param.put("password",password);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = userInfoMapper.findUserInfoByCond(param);
        userInfos.forEach(System.out::println);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByNameAndSexWithIf() {

        //接收参数
        String uname = "i";
        String sex = "1";

        //处理参数
/*        uname = "%" + uname + "%";
        sex = "%" + sex + "%";*/
        //封装对象
        UserInfo userInfo = new UserInfo();
//        userInfo.setUname(uname);
        userInfo.setSex(sex);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = userInfoMapper.selectByNameAndSexWithIf(userInfo);
//        System.out.println(userInfos);
        userInfos.forEach(System.out::println);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void findUserInfoByNameAndSex_Choose() {

        //接收参数
        String uname = "i";
        String sex = "1";
        String email = "111";

        //处理参数
/*        uname = "%" + uname + "%";
        sex = "%" + sex + "%";*/
        //封装对象
        UserInfo userInfo = new UserInfo();
//        userInfo.setUname(uname);
//        userInfo.setSex(sex);
        userInfo.setEmail(email);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = userInfoMapper.findUserInfoByNameAndSexWithChoose(userInfo);
//        System.out.println(userInfos);
        userInfos.forEach(System.out::println);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() {
        //接收参数
        int status = 1;
        String uname = "chichi";
        String realName = "赤赤";

        //处理参数
/*        uname = "%" + uname + "%";
        realName = "%" + realName + "%";*/
        //封装对象
        UserInfo userInfo = new UserInfo();
        userInfo.setStatus(status);
        userInfo.setUname(uname);
        userInfo.setRealName(realName);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = userInfoMapper.selectByConditionSingle(userInfo);
//        System.out.println(userInfos);
        userInfos.forEach(System.out::println);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void findUserInfoForeach() {
        //接收参数
        int[] ids = {1,2,3};

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        List<UserInfo> userInfos = userInfoMapper.findUserInfoForeach(ids);
//        System.out.println(userInfos);
        userInfos.forEach(System.out::println);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAddUserInfo() {
        int status = 1;
        String uname = "chichi4";
        String upass = "4";
        String realName = "赤赤4";
        String sex = "0";
        String address = "11";
        String email = "11";
        Date regDate = new Date();
        UserInfo userInfo = new UserInfo();
        userInfo.setUname(uname);
        userInfo.setUpass(upass);
        userInfo.setRealName(realName);
        userInfo.setSex(sex);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setRegDate(regDate);
        userInfo.setStatus(status);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        userInfoMapper.addUserInfo(userInfo);
        System.out.println("插入成功!");
        System.out.println(userInfo.getUid());
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void InsertUserInfoTest() {
        int status = 1;
        String uname = "Lily";
        String upass = "123456";
        String realName = "莉莉";
        String sex = "0";
        String address = "11";
        String email = "11";
        Date regDate = new Date();
        UserInfo userInfo = new UserInfo();
        userInfo.setUname(uname);
        userInfo.setUpass(upass);
        userInfo.setRealName(realName);
        userInfo.setSex(sex);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setRegDate(regDate);
        userInfo.setStatus(status);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        int row = userInfoMapper.insertUserInfoByCond(userInfo);
        if (row>0) {
            System.out.println("插入成功!");
        } else {
            System.out.println("插入失败!");
        }
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void testUpdateUserInfo() {
        //接收参数
        int status = 0;
        String uname = "chichi4";
        String upass = "5";
        String realName = "赤赤4";
        String sex = "1";
        String address = "11";
        String email = "11";
        Date regDate = new Date();
        int uid = 6;

        //封装对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUname(uname);
        userInfo.setUpass(upass);
        userInfo.setRealName(realName);
        userInfo.setSex(sex);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setRegDate(regDate);
        userInfo.setStatus(status);
        userInfo.setUid(uid);

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        int count = userInfoMapper.updateUserInfo(userInfo);
        if (count > 0) {
            System.out.println("修改了" + count + "行");
        } else System.out.println("修改失败");
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteUserInfoById() {
        //接收参数
        int uid = 10; //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取Mapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        //4.执行方法
        userInfoMapper.deleteUserInfoById(uid);

        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

}

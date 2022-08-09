package org.beatrace.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.beatrace.mybatis.mapper.UserMapper;
import org.beatrace.mybatis.pojo.User;
import org.beatrace.mybatis.utils.SqlSessionUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    /**
     * sqlsession默认不自动提交事务，如果需要自动提交事务，可以使用SqlSessionFactory.openSession(true);
     * @throws IOException
     */

    @Test
    public void testInsertUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式
        //测试功能
        int result = mapper.insertUser();
        //提交事务（写的type是JDBC）
//        sqlSession.commit();
        System.out.println("result: " + result);
    }

    @Test
    public void testselectAll() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式
        //测试功能
        List<User> results = mapper.selectAll();
        for(User result : results) {
            System.out.println(result);
        }

    }

    @Test
    public void testGetUserById() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式
        //测试功能
        User result = mapper.getUserById();
        System.out.println(result);
    }

    @Test
    public void testupdateUser() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式
        //测试功能
        int count = mapper.updateUser();
        System.out.println(count);
    }

    @Test
    public void testgetUserByUsername() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式
        //测试功能
        User res = mapper.getUserByUsername("张三");
        System.out.println(res);
    }

    @Test
    public void testcheckLogin() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式
        //测试功能
        User res = mapper.checkLogin("张三","356");
        System.out.println(res);
    }
}

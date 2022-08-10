package org.beatrace.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.beatrace.mybatis.mapper.UserMapper;
import org.beatrace.mybatis.pojo.User;
import org.beatrace.mybatis.utils.SqlSessionUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    /**
     * sqlsession默认不自动提交事务，如果需要自动提交事务，可以使用SqlSessionFactory.openSession(true);
     * @throws IOException
     */

    private static Logger logger = Logger.getLogger(MyBatisTest.class);
//    @Test
//    public void testInsertUser() throws IOException {
//        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        //获取mapper接口对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式
//        //测试功能
//        int result = mapper.insertUser();
//        //提交事务（写的type是JDBC）
////        sqlSession.commit();
//        System.out.println("result: " + result);
//    }

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

    @Test
    public void testcheckLoginByMap() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式
        //测试功能
        Map<String, Object> map = new HashMap<>();
        map.put("username", "张三");
        map.put("password", "356");
        User res = mapper.checkLoginByMap(map);
        System.out.println(res);
    }

    /**
     * 情况4：mapper接口方法的参数是实体类类型的参数（web从control层传过来的）
     * 只需要通过#{} ${}以属性的方式访问属性值即可，但是需要注意${}的单引号问题
     */
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //代理模式

        User user = new User(null, "Pandora", "4444", 66, "m", "1111@gmail.com");
        mapper.insertUser(user);
    }


    /**
     * 情况5：使用@Param注解来命名参数
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a》以@Param的值为键，参数为值; @Param(value = "xxx")
     * b》以param0，param1...为键，参数为值
     */
    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("Pandora","4444");
        System.out.println(user);
    }

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUserByLike("兔兔");
        System.out.println(user);
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteMore("12, 13");
        System.out.println(result);
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> t_user = mapper.getUserByTableName("t_book");
        System.out.println(t_user);
    }

    @Test
    public void testInsetUser2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insetUser2(new User(null, "兔兔","111",11,"f","abc@qq.com"));
    }





}

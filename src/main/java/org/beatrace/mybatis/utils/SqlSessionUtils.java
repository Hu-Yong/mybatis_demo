package org.beatrace.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try{
            //加载核心配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlsessionfactorybuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取factory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取sqlsession
            sqlSession = sqlSessionFactory.openSession(true);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}

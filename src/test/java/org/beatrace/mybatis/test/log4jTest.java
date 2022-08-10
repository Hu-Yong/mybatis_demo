package org.beatrace.mybatis.test;


import org.apache.log4j.Logger;
import org.junit.Test;

public class log4jTest {
    //获取日志记录器Logger，名字为本类类名
    private static Logger logger = Logger.getLogger(log4jTest.class);
    @Test
    public void testLog4j() {
        for(int i=0;i<3;i++){
            // 记录debug级别的信息
            logger.debug("log4j日志输出：This is debug message.");
            // 记录info级别的信息
            logger.info("log4j日志输出：This is info message.");
            // 记录error级别的信息
            logger.error("log4j日志输出：This is error message.");
        }
    }
}

package org.beatrace.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.beatrace.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int insertUser();

    User getUserById();

    int updateUser();

    List<User> selectAll();

    User getUserByUsername(String username);

    User checkLogin(String username,String password);

    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录 （使用@Param）
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(String ids);

    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(String tableName);
}

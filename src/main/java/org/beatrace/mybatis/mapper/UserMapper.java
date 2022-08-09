package org.beatrace.mybatis.mapper;

import org.beatrace.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    int insertUser();

    User getUserById();

    int updateUser();

    List<User> selectAll();

    User getUserByUsername(String username);

    User checkLogin(String username,String password);
}

package org.beatrace.mybatis.mapper;

import org.beatrace.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    int insertUser();
    List<User> selectAll();
}

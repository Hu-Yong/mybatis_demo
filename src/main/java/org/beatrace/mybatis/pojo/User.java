package org.beatrace.mybatis.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private  String email;
}

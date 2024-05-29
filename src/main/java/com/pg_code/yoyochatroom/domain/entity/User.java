package com.pg_code.yoyochatroom.domain.entity;

import lombok.Data;

/**
 * @Classname User
 * @Date 2024/5/29 11:11
 * @Created by PG_Code
 */
@Data
public class User {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;
}

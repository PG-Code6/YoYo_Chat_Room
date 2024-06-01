package com.pg_code.yoyochatroom.mapper;

import com.pg_code.yoyochatroom.domain.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Classname UserMapper
 * @Date 2024/5/29 11:12
 * @Created by PG_Code
 */
@Mapper
public interface UserMapper {

    /**
     * 新增用户
     * @param user
     * @return
     */

    int insertUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteUser(Integer userId);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询用户
     * @param userId
     * @return
     */
    User selectUser(Integer userId);

    /**
     * 查询所有用户
     * @param
     * @return
     */
    List<User> selectAllUser();
}

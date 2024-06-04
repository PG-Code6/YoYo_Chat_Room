package com.pg_code.yoyochatroom.service;


import com.pg_code.yoyochatroom.domain.entity.User;
import com.pg_code.yoyochatroom.exception.ServiceException;
import com.pg_code.yoyochatroom.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserService
 * @Date 2024/5/29 11:35
 * @Created by PG_Code
 */
@Service
public class UserService {

   @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     * @param user
     * @return
     */
   public int insertUser(User user) {
       return userMapper.insertUser(user);
   }

    /**
     * 更新用户
     * @param user
     * @return
     */
   public int updateUser(User user) {
       return userMapper.updateUser(user);
   }

    /**
     * 查询用户
     * @param userId
     * @return
     */
   public User selectUser(Integer userId) {
       return userMapper.selectUser(userId);
   }

    /**
     * 查询所有用户
     * @return
     */
   public List<User> selectAllUser() {
       return userMapper.selectAllUser();
   }

    /**
     * 删除用户
     * @param userId
     * @return
     */
   public int deleteUser(Integer userId) {
       return userMapper.deleteUser(userId);
   }

    public List<User>  selectByMo(Integer userId, String userName) {
       return userMapper.selectByMo(userId,userName);

    }

    public User selectUserByName(String userName) {
       return userMapper.selectUserByName(userName);
    }

    public User login(User user) {
       User dbUser = userMapper.selectUserByName(user.getUserName());
       if(dbUser==null){
           //抛出一个自定义的异常
           throw new ServiceException("用户名不存在");
       }
       if(!user.getUserPassword().equals(dbUser.getUserPassword())){
           throw new ServiceException("用户名或密码错误");
       }
       return dbUser;
    }
}

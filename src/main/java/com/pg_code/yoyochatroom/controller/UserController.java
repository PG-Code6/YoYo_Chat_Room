package com.pg_code.yoyochatroom.controller;

import com.pg_code.yoyochatroom.common.Result;
import com.pg_code.yoyochatroom.domain.entity.User;
import com.pg_code.yoyochatroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname UserController
 * @Date 2024/5/29 11:41
 * @Created by PG_Code
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @GetMapping("/selectUserById")
    private Result selectUser(@RequestParam Integer userId) {
        return Result.success(userService.selectUser(userId));
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/selectAllUser")
    private Result selectAllUser() {
        return Result.success(userService.selectAllUser());
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PutMapping("/insertUser")
    private Result insertUser(@RequestBody User user) {
        return userService.insertUser(user) > 0 ? Result.success() : Result.error();
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @DeleteMapping("/deleteUser")
    private Result deleteUser(@RequestParam Integer userId) {
        return userService.deleteUser(userId) > 0 ? Result.success() : Result.error();
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    private Result updateUser(@RequestBody User user) {
        return userService.updateUser(user) > 0 ? Result.success() : Result.error();
    }

}

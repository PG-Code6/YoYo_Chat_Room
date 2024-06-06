package com.pg_code.yoyochatroom.controller;

import com.pg_code.yoyochatroom.common.Result;
import com.pg_code.yoyochatroom.domain.entity.User;
import com.pg_code.yoyochatroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 根据用户名查询用户信息。
     *
     * 本方法通过GET请求方式，接收一个用户名作为参数，调用userService中的selectUserByName方法，
     * 查询对应用户名的用户信息。目前方法实现中并未返回具体的查询结果，仅返回一个操作成功的标志。
     *
     * @param userName 要查询的用户名
     * @return 返回操作结果，成功时返回一个空的成功标志
     */
    @GetMapping("/selectUserByName")
    private Result selectUserByName(@RequestParam String userName) {
        return Result.success(userService.selectUserByName(userName));
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
        System.out.println("user = " + user);
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


    /**
     * 模糊查询
     * @return
     */
    @GetMapping("/selectByMo")
    private Result selectByMo(@RequestParam Integer userId, @RequestParam String userName) {
        List<User> userList = userService.selectByMo(userId,userName);
        return Result.success(userList);
    }


}

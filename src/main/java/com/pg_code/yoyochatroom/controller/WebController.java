package com.pg_code.yoyochatroom.controller;


import com.pg_code.yoyochatroom.common.Result;
import com.pg_code.yoyochatroom.domain.entity.User;
import com.pg_code.yoyochatroom.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class WebController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if(user.getUserName().equals("") || user.getUserPassword().equals(""))
        {
            return Result.error("用户名或密码不能为空");
        }
        User loginUser =userService.login(user);
        return Result.success(loginUser);

    }




}

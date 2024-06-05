package com.pg_code.yoyochatroom.controller;

import com.pg_code.yoyochatroom.common.Result;
import com.pg_code.yoyochatroom.domain.entity.Information;
import com.pg_code.yoyochatroom.domain.entity.User;
import com.pg_code.yoyochatroom.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能：
 * 作者：chen
 * 日期： 2024/5/31 9:11
 **/
@CrossOrigin
@RestController
@RequestMapping("/information")
public class InformationController {
    // 注入InformationService，用于处理信息相关的数据库操作
    @Autowired
    private InformationService informationService;

    /**
     * 插入信息到数据库
     *
     * @param information 要插入的信息对象
     * @return 返回操作结果，成功则返回Result.success()，失败则返回Result.error()
     */
    @PutMapping("/insertInformation")
    private Result insertInformation(@RequestBody Information information) {
        // 调用informationService的插入方法，根据返回的受影响行数判断操作成功与否
        return informationService.insertInformation(information) > 0 ? Result.success() : Result.error();
    }

    /**
     * 根据ID删除信息
     *
     * @param infId 要删除的信息的ID
     * @return 返回操作结果，成功则返回Result.success()，失败则返回Result.error()
     */
    @DeleteMapping("/deleteInformation")
    private Result deleteInformation(@RequestParam Integer infId) {
        // 调用informationService的删除方法，根据返回的受影响行数判断操作成功与否
        return informationService.deleteInformation(infId) > 0 ? Result.success() : Result.error();
    }

    /**
     * 通过用户ID查询用户信息。
     *
     * @return 返回查询结果，封装在Result对象中。若查询成功，Result对象中将包含用户信息；若查询失败，Result对象中将包含错误信息。
     */
    @GetMapping("/selectInformation")
    public Result selectInformation(@RequestParam String infSendName, @RequestParam String infReceiveName) {
        // 根据传入的userId查询用户信息，然后将信息封装在informationList数组中返回


        List<Information> informationList = informationService.selectInformationBySendIdReceiveId(infSendName, infReceiveName);

        // 根据查询结果判断操作是否成功，这里直接返回成功，因为查询操作本身不涉及修改数据库影响行数的概念
        // 实际上，你应该检查informationList是否为空或有数据来决定返回的成功或错误信息
        //return informationList != null && !informationList.isEmpty() ? Result.success(informationList) : Result.error("未找到相关信息");
        System.out.println("informationList:" + informationList);
        return Result.success(informationList);
    }

}

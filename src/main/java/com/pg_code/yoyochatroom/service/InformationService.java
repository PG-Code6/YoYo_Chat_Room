package com.pg_code.yoyochatroom.service;

import com.pg_code.yoyochatroom.common.Result;
import com.pg_code.yoyochatroom.domain.entity.Information;
import com.pg_code.yoyochatroom.domain.entity.User;
import com.pg_code.yoyochatroom.mapper.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 功能：
 * 作者：chen
 * 日期： 2024/5/31 9:58
 **/
@Service
public class InformationService {
    @Autowired // 自动注入InformationMapper
    private InformationMapper informationMapper;
    @Autowired
    private UserService userService;
    /**
     * 插入一条信息数据
     * @param information 要插入的信息对象
     * @return 返回插入操作影响的行数
     */
    public int insertInformation(Information information) {
        information.setInfSendId(userService.selectUserByName(information.getInfSendName()).getUserId());
        information.setInfReceiveId(userService.selectUserByName(information.getInfReceiveName()).getUserId());
        System.out.println(information);
        return informationMapper.insertInformation(information);
    }

    /**
     * 根据信息ID删除一条信息数据
     * @param infId 要删除的信息的ID
     * @return 返回删除操作影响的行数
     */
    public int deleteInformation(Integer infId) {
        return informationMapper.deleteInformation(infId);
    }




    /**
     * 根据用户ID选择信息列表。
     *
     * @return 返回一个信息列表，这些信息与给定的用户ID相关联。
     */
   public List<Information> selectInformationBySendIdReceiveId(String infSendName, String infReceiveName) {
       Integer infSendId = userService.selectUserByName(infSendName).getUserId();
       Integer infReceiveId = userService.selectUserByName(infReceiveName).getUserId();
    // 获取发送者用户信息
       User senderUser = userService.selectUser(infSendId);
        // 获取接收者用户信息
       User receiverUser = userService.selectUser(infReceiveId);


        // 查询信息列表
        List<Information> informationList = informationMapper.selectInformationBySendIdReceiveId(infSendId, infReceiveId);

        // 遍历信息列表，为每个Information对象设置发送者和接收者名称
        for (Information info : informationList) {
           info.setInfSendName(userService.selectUser(info.getInfSendId()).getUserName());
           info.setInfReceiveName(userService.selectUser(info.getInfReceiveId()).getUserName());
        }

        return informationList;
    }


}

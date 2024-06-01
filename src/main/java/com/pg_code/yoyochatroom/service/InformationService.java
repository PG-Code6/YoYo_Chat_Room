package com.pg_code.yoyochatroom.service;

import com.pg_code.yoyochatroom.common.Result;
import com.pg_code.yoyochatroom.domain.entity.Information;
import com.pg_code.yoyochatroom.mapper.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 插入一条信息数据
     * @param information 要插入的信息对象
     * @return 返回插入操作影响的行数
     */
    public int insertInformation(Information information) {
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
     * @param userId 用户的唯一标识符。
     * @return 返回一个信息列表，这些信息与给定的用户ID相关联。
     */
    public List<Information> selectInformationByUserId(Integer userId) {
        // 通过用户ID从数据库中查询相关信息
        return informationMapper.selectInformationByUserId(userId);
    }
}

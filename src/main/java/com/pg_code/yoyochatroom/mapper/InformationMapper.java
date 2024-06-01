package com.pg_code.yoyochatroom.mapper;

import com.pg_code.yoyochatroom.domain.entity.Information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 标明这是一个Mapper接口，用于数据库操作
public interface InformationMapper {

    /**
     * 插入信息到数据库。
     * 
     * @param information 包含要插入的信息的对象。
     * @return 返回插入操作影响的行数。
     */
    int insertInformation(Information information);

    /**
     * 根据信息ID删除数据库中的信息。
     * 
     * @param infId 要删除的信息的ID。
     * @return 返回删除操作影响的行数。
     */
    int deleteInformation(Integer infId);



    /**
     * 根据用户ID选择信息列表。
     *
     * @param sendId,receiveId 用户的唯一标识符。
     * @return 返回一个包含该用户相关联信息的列表。如果用户没有信息，则返回空列表。
     */
    List<Information> selectInformationBySendIdReceiveId(Integer sendId, Integer receiveId);
}

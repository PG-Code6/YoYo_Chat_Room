package com.pg_code.yoyochatroom.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 功能：
 * 作者：chen
 * 日期： 2024/5/31 8:28
 **/
@Data
public class Information {

    private Integer infId; // 消息ID

    private Integer infSendId; // 发送者ID

    private Integer infReceiveId; // 接收者ID，默认0

    private String infContent; // 消息内容，最大长度4000字符

    private LocalDateTime infTime; // 消息时间


}
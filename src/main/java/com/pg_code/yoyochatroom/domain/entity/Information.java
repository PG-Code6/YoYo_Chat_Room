package com.pg_code.yoyochatroom.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private String  infSendName;//发送者名称

    private Integer infReceiveId; // 接收者ID，默认0

    private String  infReceiveName;//  接收者名称


    private String infContent; // 消息内容，最大长度4000字符

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime infTime; // 消息时间

}
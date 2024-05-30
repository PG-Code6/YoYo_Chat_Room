package com.pg_code.yoyochatroom.exception;

import lombok.Getter;

/**  业务层异常捕获
 * @Classname ServiceException
 * @Date 2024/5/8 19:46
 * @Created by PG_Code
 */
@Getter
public class ServiceException extends RuntimeException{

    private String code;

    public ServiceException(String msg){
        super(msg);
        this.code = "500";
    }

    public ServiceException(String code,String msg){
        super(msg);
        this.code = code;
    }
}

package com.pg_code.yoyochatroom.exception;

import com.pg_code.yoyochatroom.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Classname GlobalException
 * @Date 2024/5/8 19:45
 * @Created by PG_Code
 */
@ControllerAdvice
public class GlobalException {

    //全局捕获异常
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result serviceException(ServiceException e){
        return Result.error("500",e.getMessage());
    }
}

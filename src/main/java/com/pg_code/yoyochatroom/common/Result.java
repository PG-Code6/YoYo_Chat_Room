package com.pg_code.yoyochatroom.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Result
 * @Date 2024/5/29 11:49
 * @Created by PG_Code
 */

@Data   //自动创建get和set方法
@AllArgsConstructor   //自动创建构造函数
@NoArgsConstructor    //无参构造
@Builder          //帮助创建对象
public class Result {

    public static final String CODE_SUCCESS = "200";
    public static final String CODE_AUTH_ERROR = "401";
    public static final String CODE_SYS_ERROR = "500";

    /**
     *  请求的返回编码 200 401 404 500
     */
    private String code;
    /**
     * 返回请求的详细信息
     */
    private String msg;
    /**
     * 返回的具体数据
     */
    private Object data;

    public static Result success(){
        // return Result.builder().code(CODE_SUCCESS).msg("请求成功").build();
        return new Result(CODE_SUCCESS,"请求成功",null);
    }

    public static Result success(Object data){
        return new Result(CODE_SUCCESS,"请求成功",data);
    }

    public static Result error(String msg){
        return new Result(CODE_SYS_ERROR,msg,null);
    }

    public static Result error(String code,String msg){
        return new Result(code,msg,null);
    }

    public static Result error(){
        return new Result(CODE_SYS_ERROR,"系统错误",null);
    }

}

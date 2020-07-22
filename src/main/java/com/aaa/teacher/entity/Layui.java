package com.aaa.teacher.entity;

import com.aaa.teacher.util.Result;
import lombok.Data;

import java.util.List;

/**
 * @fileName: Layui
 * @description: Layui返回格式
 * @author: Mr.Chen
 * @createTime: 2020-07-16 15:10
 * @version:1.0.0
 **/


@Data
public class Layui {
    private int code;
    private String msg;
    private int count;
    private List<?> data;

    public Result success(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }

    public Result error(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("失败");
        return result;
    }

}

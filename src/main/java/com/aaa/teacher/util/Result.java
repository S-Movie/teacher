package com.aaa.teacher.util;

import com.aaa.teacher.entity.Layui;
import lombok.Data;

/**
 * @fileName: Result
 * @description:
 * @author: Mr.Chen
 * @createTime: 2020-07-18 11:03
 * @version:1.0.0
 **/

@Data
public class Result extends Layui {
    private int code;
    private String msg;
}

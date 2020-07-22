package com.aaa.teacher.controller;


import com.aaa.teacher.entity.Dept;
import com.aaa.teacher.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    
    @Autowired
    private DeptService deptService;
    
    @RequestMapping("selectAllUser")
    public String deptList(){
        List<Dept> deptList = deptService.selectList(null);
        return "user";
    }

}


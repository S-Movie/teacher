package com.aaa.teacher.controller;


import com.aaa.teacher.entity.Layui;
import com.aaa.teacher.entity.Userinfo;
import com.aaa.teacher.service.UserinfoService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
@Controller
@RequestMapping("/userinfo")
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/listTea")
    public String listTea(Model model){
        List<Userinfo> teacherList = userinfoService.selectList(null);
        model.addAttribute("teaList",teacherList);
        return "teaList";
    }

    @RequestMapping("/deleteTea")
    @ResponseBody
    public String deleteTea(Integer tid){
        boolean deleteById = userinfoService.deleteById(tid);
        if (deleteById==true){
            return "redirect:/teacher/listTea";
        }else {
            return "error";
        }
    }

    @RequestMapping("/addTea")
    public String addTea(Userinfo userinfo){
        boolean insert = userinfoService.insert(userinfo);
        if (insert){
            return "redirect:/teacher/listTea";
        }
        return "error";
    }
    @RequestMapping("/toUpdateTea")
    public String toUpdateTea(Model model,Integer tid){
        Userinfo userinfo = userinfoService.selectById(tid);
        model.addAttribute("teaUpdate",userinfo);
        return "updateTea";
    }

    @RequestMapping("/updateTea")
    public String updateTea(Userinfo userinfo,Model model){
        boolean update = userinfoService.updateById(userinfo);
        if (update == true){
            return "redirect:/teacher/listTea";
        }else {
            model.addAttribute("msg","错了呀！");
            return "/html/toUpdateTea";
        }

    }
    @RequestMapping("toListTeaLayui")
    public String toListTeaLayui(){
        return "teaList";
    }

    @RequestMapping("listTeaLayui")
    @ResponseBody
    public Layui listTeaLayui(Integer page,Integer limit){
        int count = userinfoService.selectCount(null);
        Page<Userinfo> teaPage = new Page(page,limit);
        Page<Userinfo> userinfoPage = userinfoService.selectPage(teaPage);
        Layui layui = new Layui();
        layui.setCode(0);
        layui.setMsg("错误");
        layui.setData(userinfoPage.getRecords());
        layui.setCount(count);
        return layui;
    }

    @RequestMapping("/addTeaUi")
    public String addTeaUi(Userinfo userinfo){
        boolean insert = userinfoService.insert(userinfo);
        if (insert){
            return "redirect:/teacher/toListTeaLayui";
        }
        return "error";
    }

    @RequestMapping("/toUpdateTeaUi")
    public Object toUpdateTeaUi(Model model,Integer tid){
        Userinfo userinfo = userinfoService.selectById(tid);
        model.addAttribute("teaUpdate",userinfo);
        return model;
    }

    @RequestMapping("/updateTeaUi")
    public String updateTeaUi(Userinfo userinfo,Model model){
        boolean update = userinfoService.updateById(userinfo);
        if (update == true){
            return "redirect:/teacher/listTea";
        }else {
            model.addAttribute("msg","错了呀！");
            return "toUpdateTea";
        }

    }
}


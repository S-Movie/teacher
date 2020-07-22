package com.aaa.teacher.controller;


import com.aaa.teacher.aop.SaveOrUpdateEntityAnn;
import com.aaa.teacher.entity.*;
import com.aaa.teacher.service.DeptService;
import com.aaa.teacher.service.RoleService;
import com.aaa.teacher.service.UserService;
import com.aaa.teacher.util.MyConstants;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/toUserListLayui")
    public String toListTeaLayui(Model model){
        //查询所有的部门信息，填充到页面下拉框中
        List<Dept> deptList = deptService.selectList(null);
        //查询所有的角色信息，填充到页面下拉框中
        List<Role> roleList = roleService.selectList(null);
        model.addAttribute("deptList",deptList);
        model.addAttribute("roleList", roleList);
        return "user";
    }

    @RequestMapping("/selectAllUser")
    @ResponseBody
    public Layui selectAllUser(Integer page, Integer limit, String searchLoginName, String searchUserName, String searchPhonenumber){
        Layui table = new Layui();
        //多条件查询所需要的集合
        Map<String,Object> condition = new HashMap(16);
        Wrapper wrapper = new EntityWrapper();
        //添加模糊查询的条件
        if (null!=searchLoginName && !"".equals(searchLoginName)){
            wrapper.like("login_name",searchLoginName);
            condition.put("login_name",searchLoginName);
        }
        if (null!=searchUserName && !"".equals(searchUserName)){
            wrapper.like("user_name",searchUserName);
            condition.put("user_name",searchUserName);
        }
        if (null!=searchPhonenumber && !"".equals(searchPhonenumber)){
            wrapper.like("phonenumber",searchPhonenumber);
            condition.put("phonenumber",searchPhonenumber);
        }
        wrapper.eq("del_flag",0);
        condition.put("del_flag",0);
        int count = userService.selectCount(wrapper);
        //如果表中没有数据。则不进行分页查询
        if (count>0){
            //获取当前的系统毫秒数
            long start = System.currentTimeMillis();
            Page<UserVo> uPage = new Page(page,limit);
            List<UserVo> userVoList = userService.selectUserVoList(uPage, condition);
            //从分页结果中提取list集合
            table.setCode(MyConstants.OPERATION_SUCCESS_CODE);
            table.setMsg(MyConstants.OPERATION_SUCCESS_MESSAGE);
            table.setData(userVoList);
            table.setCount(count);
            long end = System.currentTimeMillis();
            System.out.println("======================查询花费时间:"+(end-start)+"=======================");
            return table;
        }else {
            return table;
        }

    }

    @RequestMapping("/saveUser")
    @ResponseBody
    @SaveOrUpdateEntityAnn(entityClass = User.class)
    public Result saveUser(User user){
        boolean insert = userService.saveUserAndSalt(user);
        if (insert){
            return success();
        }
        return error();
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    @SaveOrUpdateEntityAnn(entityClass = User.class)
    public Result updateUser(User user){
        boolean update = userService.updateById(user);
        if (update){
            return success();
        }else {
            return error();
        }
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public int deleteUser(Integer userId){
        return userService.updateFlagById(userId);
    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public Result checkUserName(String username){
        Wrapper<User> wrapper = new EntityWrapper<>();
        User user = userService.selectOne(wrapper.eq("login_name", username));
        if (user != null) {
            return  super.error(MyConstants.OPERATION_FAIL_CODE, username+"已经被占用");
        }
        return super.success();
    }

    /**
     * @description: 根据用户id查询自己的角色
     * @create time: 2020/7/18 21:28
     */
    @RequestMapping("getRoleCheckByUserId")
    @ResponseBody

    public Result getRoleCheckByUserId(Integer userId){
        List<Role> roleUserList = roleService.selectListByUserId(userId);
        List<Role> roleList = roleService.selectList(null);
        Map map = new HashMap(16);
        for (Role role : roleList) {
            //判断集合包含对象，必须重写equals和hashcode方法
            if (roleUserList.contains(role)){
                map.put(role.getRoleKey(),true);
            }else {
                map.put(role.getRoleKey(),false);
            }
        }
        return success(map);

    }

    @RequestMapping("/deleteBatchDept")
    @ResponseBody
    public com.aaa.teacher.entity.Result deleteBatchDept(@RequestBody List<User> userList){
        List<User> userListNew = new ArrayList<>();
        //此处是逻辑删除，修改delflag
        for (User user : userList) {
            User userNew = new User();
            userNew.setDelFlag("1");
            userNew.setUserId(user.getUserId());
            userListNew.add(userNew);
        }
        boolean update = userService.updateBatchById(userListNew);
        if (update){
            return super.success();
        }else {
            return super.error();
        }
    }

    @RequestMapping("/resetPassword")
    @ResponseBody
    public Result resetPassword(User user){

        boolean update = userService.resetPassword(user);
        if (update){
            return success();
        }else {
            return error();
        }
    }
}


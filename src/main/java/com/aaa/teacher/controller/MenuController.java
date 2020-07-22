package com.aaa.teacher.controller;


import com.aaa.teacher.entity.LayUiTable;
import com.aaa.teacher.entity.LayUiTree;
import com.aaa.teacher.entity.Menu;
import com.aaa.teacher.service.MenuService;
import com.aaa.teacher.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/findAllMenus")
    @ResponseBody
    public List<LayUiTree> findAllMenus(){
        List<LayUiTree> layUiTreeList = menuService.findMenus(null);
        return layUiTreeList;
    }
    @RequestMapping("/toShowMenu")
    public String toShowMenu(){
        return "menu/showMenu";
    }

    @RequestMapping("/findAllMenusTreeTable")
    @ResponseBody
    public LayUiTable findAllMenusTreeTable(){
        List<Menu> menuList = menuService.selectList(null);
        LayUiTable table = new LayUiTable();
        table.setCode(MyConstants.OPERATION_SUCCESS_CODE);
        table.setMsg(MyConstants.OPERATION_SUCCESS_MESSAGE);
        table.setData(menuList);
        table.setCount(menuList.size());
        return table;
    }
}


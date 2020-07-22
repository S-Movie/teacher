package com.aaa.teacher.service;

import com.aaa.teacher.entity.LayUiTree;
import com.aaa.teacher.entity.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
public interface MenuService extends IService<Menu> {
    List<LayUiTree> findMenus(String loginName);
    Set<String> findAllMenusByLoginName(String loginName);
}

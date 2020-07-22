package com.aaa.teacher.service;

import com.aaa.teacher.entity.Role;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
public interface RoleService extends IService<Role> {

    List<Role> selectListByUserId(Integer userId);

}

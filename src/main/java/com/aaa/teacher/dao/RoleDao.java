package com.aaa.teacher.dao;

import com.aaa.teacher.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
public interface RoleDao extends BaseMapper<Role> {
    List<Role> selectListByUserId(Integer userId);

}

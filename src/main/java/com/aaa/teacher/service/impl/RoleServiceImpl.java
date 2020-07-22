package com.aaa.teacher.service.impl;

import com.aaa.teacher.entity.Role;
import com.aaa.teacher.dao.RoleDao;
import com.aaa.teacher.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Autowired
    private  RoleDao roleDao;

    @Override
    public List<Role> selectListByUserId(Integer userId) {
        return roleDao.selectListByUserId(userId);
    }
}

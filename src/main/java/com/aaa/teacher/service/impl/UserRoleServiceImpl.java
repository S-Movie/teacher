package com.aaa.teacher.service.impl;

import com.aaa.teacher.entity.UserRole;
import com.aaa.teacher.dao.UserRoleDao;
import com.aaa.teacher.service.UserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

}

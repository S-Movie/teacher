package com.aaa.teacher.service.impl;

import com.aaa.teacher.entity.Dept;
import com.aaa.teacher.dao.DeptDao;
import com.aaa.teacher.service.DeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements DeptService {

}

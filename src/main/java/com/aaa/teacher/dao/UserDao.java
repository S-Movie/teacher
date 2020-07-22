package com.aaa.teacher.dao;

import com.aaa.teacher.entity.User;
import com.aaa.teacher.entity.UserVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {

    List<UserVo> selectUserVoList(Page<UserVo> pageInfo, @Param("condition")Map<String,Object> condition);
    int updateFlagById(Integer userId);
    int updateUserColumById(User user);

    int resetPassword(User user);
}

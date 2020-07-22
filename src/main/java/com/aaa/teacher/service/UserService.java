package com.aaa.teacher.service;

import com.aaa.teacher.entity.User;
import com.aaa.teacher.entity.UserVo;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
public interface UserService extends IService<User> {
    List<UserVo> selectUserVoList(Page<UserVo> pageInfo, @Param("condition") Map<String,Object> condition);

    int updateFlagById(Integer userId);

    boolean saveUserAndSalt(User user);
    boolean updateUserAndSalt(User user);
    boolean resetPassword(User user);

}

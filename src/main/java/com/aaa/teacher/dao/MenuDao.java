package com.aaa.teacher.dao;



import com.aaa.teacher.entity.Menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author AAAStudent
 * @since 2020-07-17
 */
public interface MenuDao extends BaseMapper<Menu> {
    /**
     *
     * @param loginName
     * @return
     */
    List<Menu> findMenusByLoginName(@Param("loginName") String loginName);
}

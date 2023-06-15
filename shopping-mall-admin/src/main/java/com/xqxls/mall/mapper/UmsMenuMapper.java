package com.xqxls.mall.mapper;

import com.xqxls.mall.base.TkBaseMapper;
import com.xqxls.mall.domain.ums.entity.UmsMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台菜单表 Mapper 接口
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsMenuMapper extends TkBaseMapper<UmsMenu> {

    /**
     * 通过用户ID查询菜单列表
     * @param adminId 用户ID
     * @return 菜单列表
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);

    /**
     * 通过角色ID查询菜单列表
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
}
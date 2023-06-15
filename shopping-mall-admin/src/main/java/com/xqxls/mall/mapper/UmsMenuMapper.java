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

    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);

    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
}
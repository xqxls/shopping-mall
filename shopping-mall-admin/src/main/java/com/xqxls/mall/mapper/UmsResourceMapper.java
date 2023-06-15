package com.xqxls.mall.mapper;

import com.xqxls.mall.base.TkBaseMapper;
import com.xqxls.mall.domain.ums.entity.UmsResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台资源表 Mapper 接口
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsResourceMapper extends TkBaseMapper<UmsResource> {

    /**
     * 通过用户ID查询资源列表
     * @param adminId 用户ID
     * @return 资源列表
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 通过角色ID查询资源列表
     * @param roleId 角色ID
     * @return 资源列表
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
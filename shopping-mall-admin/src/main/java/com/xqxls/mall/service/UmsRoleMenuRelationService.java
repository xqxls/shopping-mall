package com.xqxls.mall.service;

import com.xqxls.mall.entity.UmsRoleMenuRelation;

import java.util.List;


/**
 * 后台角色菜单关系表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsRoleMenuRelationService extends IService<UmsRoleMenuRelation> {

    /**
     * 通过角色删除角色菜单关系
     * @param roleId 角色ID
     */
    void deleteByRoleId(Long roleId);

    /**
     * 通过角色批量删除角色菜单关系
     * @param roleIds 角色ID列表
     */
    void deleteByRoleIds(List<Long> roleIds);
}

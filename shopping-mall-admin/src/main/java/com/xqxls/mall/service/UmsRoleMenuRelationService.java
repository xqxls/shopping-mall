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

    void deleteByRoleId(Long roleId);

    void deleteByRoleIds(List<Long> roleIds);
}

package com.xqxls.mall.mapper;

import com.xqxls.mall.base.TkBaseMapper;
import com.xqxls.mall.domain.ums.entity.UmsAdminRoleRelation;
import com.xqxls.mall.domain.ums.entity.UmsResource;
import com.xqxls.mall.domain.ums.entity.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户和角色关系表 Mapper 接口
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsAdminRoleRelationMapper extends TkBaseMapper<UmsAdminRoleRelation> {

    /**
     * 通过资源ID查询用户ID列表
     * @param resourceId 资源ID
     * @return 用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);

    /**
     * 通过用户ID查询资源列表
     * @param adminId 用户ID
     * @return 资源列表
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 通过用户ID查询角色列表
     * @param adminId 用户ID
     * @return 角色列表
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 通过用户ID删除用户角色关系
     * @param adminId 用户ID
     * @return 成功删除条数
     */
    int delByAdminId(@Param("adminId") Long adminId);
}
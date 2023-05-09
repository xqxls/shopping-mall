package com.xqxls.mall.mapper;

import com.xqxls.mall.base.TkBaseMapper;
import com.xqxls.mall.entity.UmsAdminRoleRelation;
import com.xqxls.mall.entity.UmsResource;
import com.xqxls.mall.entity.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户和角色关系表 Mapper 接口
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsAdminRoleRelationMapper extends TkBaseMapper<UmsAdminRoleRelation> {

    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);

    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    int delByAdminId(@Param("adminId") Long adminId);
}
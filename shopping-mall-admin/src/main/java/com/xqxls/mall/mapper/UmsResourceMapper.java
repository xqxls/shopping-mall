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

    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
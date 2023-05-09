package com.xqxls.mall.service;

import com.github.pagehelper.PageInfo;
import com.xqxls.mall.entity.UmsMenu;
import com.xqxls.mall.entity.UmsResource;
import com.xqxls.mall.entity.UmsRole;

import java.util.List;


/**
 * 后台用户角色表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsRoleService extends IService<UmsRole> {

    List<UmsMenu> getMenuList(Long adminId);

    int create(UmsRole umsRole);

    void deleteByIds(List<Long> ids);

    List<UmsRole> list(String keyword, Integer page, Integer size);

    List<UmsMenu> listMenu(Long roleId);

    List<UmsResource> listResource(Long roleId);

    int allocMenu(Long roleId, List<Long> menuIds);

    int allocResource(Long roleId, List<Long> resourceIds);
}

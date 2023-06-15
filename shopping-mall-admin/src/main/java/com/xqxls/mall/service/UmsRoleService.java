package com.xqxls.mall.service;

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

    /**
     * 通过用户获取菜单列表
     * @param adminId 用户ID
     * @return 菜单列表
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * 新增角色
     * @param umsRole 角色
     * @return 成功新增条数
     */
    int create(UmsRole umsRole);

    /**
     * 批量删除角色
     * @param ids 角色ID列表
     */
    void deleteByIds(List<Long> ids);

    /**
     * 查询角色分页信息
     * @param keyword 搜索关键词
     * @param page 当前页
     * @param size 每一页记录数
     * @return 角色分页信息
     */
    List<UmsRole> list(String keyword, Integer page, Integer size);

    /**
     * 通过角色查询菜单列表
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * 通过角色查询资源列表
     * @param roleId 角色ID
     * @return 资源列表
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     * @param roleId 角色ID
     * @param menuIds 菜单ID列表
     * @return 成功分配菜单数量
     */
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     * @param roleId 角色ID
     * @param resourceIds 资源ID列表
     * @return 成功分配资源数量
     */
    int allocResource(Long roleId, List<Long> resourceIds);
}

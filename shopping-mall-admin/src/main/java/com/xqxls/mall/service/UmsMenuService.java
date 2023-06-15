package com.xqxls.mall.service;

import com.xqxls.mall.dto.UmsMenuNode;
import com.xqxls.mall.entity.UmsMenu;

import java.util.List;


/**
 * 后台菜单表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsMenuService extends IService<UmsMenu> {

    /**
     * 新增菜单
     * @param umsMenuEntity 菜单实体
     * @return 成功新增条数
     */
    int create(UmsMenu umsMenuEntity);

    /**
     * 更新菜单
     * @param id 菜单ID
     * @param umsMenuEntity 菜单实体
     * @return 成功更新条数
     */
    int update(Long id, UmsMenu umsMenuEntity);

    /**
     * 分页查询菜单
     * @param parentId 父级ID
     * @param page 当前页
     * @param size 每一页记录数
     * @return 菜单列表
     */
    List<UmsMenu> list(Long parentId, Integer page, Integer size);

    /**
     * 树形结构返回所有菜单列表
     * @return 菜单节点列表
     */
    List<UmsMenuNode> treeList();

    /**
     * 修改菜单显示状态
     * @param id 菜单ID
     * @param hidden 显示状态
     * @return 成功更新条数
     */
    int updateHidden(Long id, Integer hidden);
}

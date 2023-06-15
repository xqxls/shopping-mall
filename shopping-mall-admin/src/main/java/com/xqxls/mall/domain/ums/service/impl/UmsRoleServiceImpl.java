package com.xqxls.mall.domain.ums.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.ums.entity.*;
import com.xqxls.mall.domain.ums.service.UmsAdminCacheService;
import com.xqxls.mall.domain.ums.service.UmsRoleMenuRelationService;
import com.xqxls.mall.domain.ums.service.UmsRoleResourceRelationService;
import com.xqxls.mall.domain.ums.service.UmsRoleService;
import com.xqxls.mall.mapper.UmsMenuMapper;
import com.xqxls.mall.mapper.UmsResourceMapper;
import com.xqxls.mall.mapper.UmsRoleMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 后台用户角色表 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService {

    @Autowired
    private UmsMenuMapper umsMenuMapper;

    @Autowired
    private UmsResourceMapper umsResourceMapper;

    @Autowired
    private UmsRoleMapper umsRoleMapper;

    @Autowired
    private UmsRoleMenuRelationService umsRoleMenuRelationService;

    @Autowired
    private UmsRoleResourceRelationService umsRoleResourceRelationService;

    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {

        return umsMenuMapper.getMenuList(adminId);
    }

    @Override
    public int create(UmsRole umsRole) {
        umsRole.setCreateTime(new Date());
        umsRole.setAdminCount(0);
        umsRole.setSort(0);
        return this.add(umsRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        // 删除角色菜单关系
        umsRoleMenuRelationService.deleteByRoleIds(ids);
        // 删除角色资源关系
        umsRoleResourceRelationService.deleteByRoleIds(ids);
        // 删除角色
        this.deleteByIdList(ids);
    }

    @Override
    public List<UmsRole> list(String keyword, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        Example example = new Example(UmsRole.class);
        Example.Criteria criteria = example.createCriteria();
        if(StrUtil.isNotEmpty(keyword)){
            criteria.andLike("name", "%"+keyword+"%");
        }
        return umsRoleMapper.selectByExample(example);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return umsMenuMapper.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return umsResourceMapper.getResourceListByRoleId(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int allocMenu(Long roleId, List<Long> menuIds) {
        // 删除原来的菜单
        umsRoleMenuRelationService.deleteByRoleId(roleId);

        // 绑定新菜单
        if(!CollectionUtils.isEmpty(menuIds)){
            List<UmsRoleMenuRelation> list = new ArrayList<>();
            for (Long menuId : menuIds) {
                UmsRoleMenuRelation menuRelation = new UmsRoleMenuRelation();
                menuRelation.setRoleId(roleId);
                menuRelation.setMenuId(menuId);
                list.add(menuRelation);
            }
            umsRoleMenuRelationService.insertBatch(list);
        }
        return menuIds.size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int allocResource(Long roleId, List<Long> resourceIds) {
        // 删除原来的资源
        umsRoleResourceRelationService.deleteByRoleId(roleId);

        // 绑定新资源
        if(!CollectionUtils.isEmpty(resourceIds)){
            List<UmsRoleResourceRelation> list = new ArrayList<>();
            for (Long resourceId : resourceIds) {
                UmsRoleResourceRelation resourceRelation = new UmsRoleResourceRelation();
                resourceRelation.setRoleId(roleId);
                resourceRelation.setResourceId(resourceId);
                list.add(resourceRelation);
            }
            umsRoleResourceRelationService.insertBatch(list);
        }
        adminCacheService.delResourceListByRole(roleId);
        return resourceIds.size();
    }
}

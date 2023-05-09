package com.xqxls.mall.service.impl;

import com.xqxls.mall.service.UmsRoleMenuRelationService;
import com.xqxls.mall.entity.UmsRoleMenuRelation;
import com.xqxls.mall.mapper.UmsRoleMenuRelationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 后台角色菜单关系表 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Service
public class UmsRoleMenuRelationServiceImpl extends ServiceImpl<UmsRoleMenuRelationMapper, UmsRoleMenuRelation> implements UmsRoleMenuRelationService {

    @Autowired
    private UmsRoleMenuRelationMapper umsRoleMenuRelationMapper;

    @Override
    public void deleteByRoleId(Long roleId) {
        Example example = new Example(UmsRoleMenuRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        umsRoleMenuRelationMapper.deleteByExample(example);
    }

    @Override
    public void deleteByRoleIds(List<Long> roleIds) {
        Example example = new Example(UmsRoleMenuRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("roleId", roleIds);
        umsRoleMenuRelationMapper.deleteByExample(example);
    }
}

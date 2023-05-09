package com.xqxls.mall.service.impl;

import com.xqxls.mall.service.UmsRoleResourceRelationService;
import com.xqxls.mall.entity.UmsRoleResourceRelation;
import com.xqxls.mall.mapper.UmsRoleResourceRelationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 后台角色资源关系表 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Service
public class UmsRoleResourceRelationServiceImpl extends ServiceImpl<UmsRoleResourceRelationMapper, UmsRoleResourceRelation> implements UmsRoleResourceRelationService {

    @Autowired
    private UmsRoleResourceRelationMapper umsRoleResourceRelationMapper;

    @Override
    public void deleteByRoleId(Long roleId) {
        Example example = new Example(UmsRoleResourceRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        umsRoleResourceRelationMapper.deleteByExample(example);
    }

    @Override
    public void deleteByRoleIds(List<Long> roleIds) {
        Example example = new Example(UmsRoleResourceRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("roleId", roleIds);
        umsRoleResourceRelationMapper.deleteByExample(example);
    }
}

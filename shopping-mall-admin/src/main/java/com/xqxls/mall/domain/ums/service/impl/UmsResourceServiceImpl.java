package com.xqxls.mall.domain.ums.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.ums.entity.UmsResource;
import com.xqxls.mall.domain.ums.service.UmsAdminCacheService;
import com.xqxls.mall.domain.ums.service.UmsResourceService;
import com.xqxls.mall.mapper.UmsResourceMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 后台资源表 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource> implements UmsResourceService {

    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Autowired
    private UmsResourceMapper umsResourceMapper;

    @Override
    public int create(UmsResource umsResource) {
        umsResource.setCreateTime(new Date());
        return this.add(umsResource);
    }

    @Override
    public int update(Long id, UmsResource umsResource) {
        umsResource.setId(id);
        int count = this.update(umsResource);
        adminCacheService.delResourceListByResource(id);
        return count;
    }

    @Override
    public int delete(Long id) {
        int count = this.deleteById(id);
        adminCacheService.delResourceListByResource(id);
        return count;
    }

    @Override
    public List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        Example example = new Example(UmsResource.class);
        Example.Criteria criteria = example.createCriteria();
        if(Objects.nonNull(categoryId)){
            criteria.andEqualTo("categoryId", categoryId);
        }
        if(StrUtil.isNotEmpty(nameKeyword)){
            criteria.andLike("name", "%"+nameKeyword+"%");
        }
        if(StrUtil.isNotEmpty(urlKeyword)){
            criteria.andLike("url", "%"+urlKeyword+"%");
        }
        return umsResourceMapper.selectByExample(example);
    }
}

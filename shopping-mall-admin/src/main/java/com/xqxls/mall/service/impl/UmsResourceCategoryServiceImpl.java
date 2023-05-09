package com.xqxls.mall.service.impl;

import com.xqxls.mall.service.UmsResourceCategoryService;
import com.xqxls.mall.entity.UmsResourceCategory;
import com.xqxls.mall.mapper.UmsResourceCategoryMapper;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 资源分类表 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Service
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryMapper, UmsResourceCategory> implements UmsResourceCategoryService {

    @Override
    public int create(UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setCreateTime(new Date());
        return this.add(umsResourceCategory);
    }
}

package com.xqxls.mall.domain.pms.service.impl;

import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.pms.dto.PmsProductAttributeCategoryItem;
import com.xqxls.mall.domain.pms.entity.PmsProductAttributeCategory;
import com.xqxls.mall.mapper.PmsProductAttributeCategoryItemMapper;
import com.xqxls.mall.mapper.PmsProductAttributeCategoryMapper;
import com.xqxls.mall.domain.pms.service.PmsProductAttributeCategoryService;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品属性分类表 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Service
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryMapper, PmsProductAttributeCategory> implements PmsProductAttributeCategoryService {

    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;

    @Autowired
    private PmsProductAttributeCategoryItemMapper pmsProductAttributeCategoryItemMapper;

    @Override
    public int create(String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setName(name);
        return this.add(productAttributeCategory);
    }

    @Override
    public int update(Long id, String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setName(name);
        productAttributeCategory.setId(id);
        return this.update(productAttributeCategory);
    }

    @Override
    public List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return productAttributeCategoryMapper.selectAll();
    }

    @Override
    public List<PmsProductAttributeCategoryItem> getListWithAttr() {
        return pmsProductAttributeCategoryItemMapper.getListWithAttr();
    }
}

package com.xqxls.mall.service;

import com.xqxls.mall.dto.PmsProductAttributeCategoryItem;
import com.xqxls.mall.entity.PmsProductAttributeCategory;

import java.util.List;


/**
 * 产品属性分类表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsProductAttributeCategoryService extends IService<PmsProductAttributeCategory> {

    int create(String name);

    int update(Long id, String name);

    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    List<PmsProductAttributeCategoryItem> getListWithAttr();
}

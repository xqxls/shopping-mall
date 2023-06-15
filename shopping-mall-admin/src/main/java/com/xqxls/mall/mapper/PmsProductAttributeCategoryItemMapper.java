package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.pms.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * @author 胡卓
 * @create 2023-05-10 11:07
 * @Description
 */
public interface PmsProductAttributeCategoryItemMapper {
    /**
     * 获取商品属性
     * @return 商品属性列表
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}

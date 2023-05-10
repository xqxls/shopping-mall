package com.xqxls.mall.mapper;

import com.xqxls.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * @author 胡卓
 * @create 2023-05-10 11:07
 * @Description
 */
public interface PmsProductAttributeCategoryItemMapper {
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}

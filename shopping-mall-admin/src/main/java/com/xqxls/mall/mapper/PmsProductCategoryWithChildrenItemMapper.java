package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.pms.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * @author 胡卓
 * @create 2023-05-10 13:20
 * @Description
 */
public interface PmsProductCategoryWithChildrenItemMapper {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}

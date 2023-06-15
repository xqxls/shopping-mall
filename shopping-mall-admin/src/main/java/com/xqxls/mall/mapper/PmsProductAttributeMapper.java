package com.xqxls.mall.mapper;

import com.xqxls.mall.base.TkBaseMapper;
import com.xqxls.mall.domain.pms.dto.ProductAttrInfo;
import com.xqxls.mall.domain.pms.entity.PmsProductAttribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品属性参数表 Mapper 接口
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsProductAttributeMapper extends TkBaseMapper<PmsProductAttribute> {
    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);
}
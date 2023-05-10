package com.xqxls.mall.service;

import com.xqxls.mall.dto.PmsProductAttributeParam;
import com.xqxls.mall.dto.ProductAttrInfo;
import com.xqxls.mall.entity.PmsProductAttribute;

import java.util.List;


/**
 * 商品属性参数表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsProductAttributeService extends IService<PmsProductAttribute> {

    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    int create(PmsProductAttributeParam productAttributeParam);

    int update(Long id, PmsProductAttributeParam productAttributeParam);

    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);

    int delete(List<Long> ids);
}

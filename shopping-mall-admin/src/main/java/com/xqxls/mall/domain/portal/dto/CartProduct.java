package com.xqxls.mall.domain.portal.dto;

import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.pms.entity.PmsProductAttribute;
import com.xqxls.mall.domain.pms.entity.PmsSkuStock;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 13:51
 * @Description 购物车中带规格和SKU的商品信息
 */
@Getter
@Setter
public class CartProduct extends PmsProduct {

    @ApiModelProperty("商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
    @ApiModelProperty("商品SKU库存列表")
    private List<PmsSkuStock> skuStockList;
}

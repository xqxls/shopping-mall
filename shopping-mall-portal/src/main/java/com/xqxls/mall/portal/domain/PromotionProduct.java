package com.xqxls.mall.portal.domain;

import com.xqxls.mall.model.PmsProduct;
import com.xqxls.mall.model.PmsProductFullReduction;
import com.xqxls.mall.model.PmsProductLadder;
import com.xqxls.mall.model.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 促销商品信息，包括sku、打折优惠、满减优惠
 * Created by xqxls on 2018/8/27.
 */
@Getter
@Setter
public class PromotionProduct extends PmsProduct {
    //商品库存信息
    private List<PmsSkuStock> skuStockList;
    //商品打折信息
    private List<PmsProductLadder> productLadderList;
    //商品满减信息
    private List<PmsProductFullReduction> productFullReductionList;
}

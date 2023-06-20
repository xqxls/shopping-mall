package com.xqxls.mall.domain.portal.dto;

import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.pms.entity.PmsProductFullReduction;
import com.xqxls.mall.domain.pms.entity.PmsProductLadder;
import com.xqxls.mall.domain.pms.entity.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 13:47
 * @Description 促销商品信息，包括sku、打折优惠、满减优惠
 */
@Getter
@Setter
public class PromotionProduct extends PmsProduct {

    /** 商品库存信息 **/
    private List<PmsSkuStock> skuStockList;
    /** 商品打折信息 **/
    private List<PmsProductLadder> productLadderList;
    /** 商品满减信息 **/
    private List<PmsProductFullReduction> productFullReductionList;
}

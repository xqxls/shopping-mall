package com.xqxls.mall.domain.portal.dto;

import com.xqxls.mall.domain.pms.entity.*;
import com.xqxls.mall.domain.sms.entity.SmsCoupon;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 14:51
 * @Description 前台商品详情
 */
@Getter
@Setter
public class PmsPortalProductDetail{

    @ApiModelProperty("商品信息")
    private PmsProduct product;
    @ApiModelProperty("商品品牌")
    private PmsBrand brand;
    @ApiModelProperty("商品属性与参数")
    private List<PmsProductAttribute> productAttributeList;
    @ApiModelProperty("手动录入的商品属性与参数值")
    private List<PmsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("商品的sku库存信息")
    private List<PmsSkuStock> skuStockList;
    @ApiModelProperty("商品阶梯价格设置")
    private List<PmsProductLadder> productLadderList;
    @ApiModelProperty("商品满减价格设置")
    private List<PmsProductFullReduction> productFullReductionList;
    @ApiModelProperty("商品可用优惠券")
    private List<SmsCoupon> couponList;
}

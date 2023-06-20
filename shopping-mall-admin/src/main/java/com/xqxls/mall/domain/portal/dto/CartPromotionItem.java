package com.xqxls.mall.domain.portal.dto;

import com.xqxls.mall.domain.oms.entity.OmsCartItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author xqxls
 * @create 2023-06-20 11:35
 * @Description 购物车中促销信息的封装
 */
@Getter
@Setter
public class CartPromotionItem extends OmsCartItem {

    @ApiModelProperty("促销活动信息")
    private String promotionMessage;
    @ApiModelProperty("促销活动减去的金额，针对每个商品")
    private BigDecimal reduceAmount;
    @ApiModelProperty("剩余库存-锁定库存")
    private Integer realStock;
    @ApiModelProperty("购买商品赠送积分")
    private Integer integration;
    @ApiModelProperty("购买商品赠送成长值")
    private Integer growth;
}

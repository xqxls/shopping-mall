package com.xqxls.mall.domain.portal.dto;

import com.xqxls.mall.domain.pms.entity.PmsProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author xqxls
 * @create 2023-06-20 10:03
 * @Description 秒杀信息和商品对象封装
 */
@Getter
@Setter
public class FlashPromotionProduct extends PmsProduct {

    @ApiModelProperty("秒杀价格")
    private BigDecimal flashPromotionPrice;

    @ApiModelProperty("用于秒杀到数量")
    private Integer flashPromotionCount;

    @ApiModelProperty("秒杀限购数量")
    private Integer flashPromotionLimit;
}

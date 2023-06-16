package com.xqxls.mall.domain.sms.dto;

import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.sms.entity.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xqxls
 * @create 2023-06-16 16:12
 * @Description 限时购商品信息封装
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {
    @Getter
    @Setter
    @ApiModelProperty("关联商品")
    private PmsProduct product;
}

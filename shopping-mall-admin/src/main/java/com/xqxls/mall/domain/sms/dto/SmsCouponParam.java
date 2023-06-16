package com.xqxls.mall.domain.sms.dto;

import com.xqxls.mall.domain.sms.entity.SmsCoupon;
import com.xqxls.mall.domain.sms.entity.SmsCouponProductCategoryRelation;
import com.xqxls.mall.domain.sms.entity.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-16 15:34
 * @Description 优惠券信息封装，包括绑定商品和分类
 */
public class SmsCouponParam extends SmsCoupon {

    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品")
    private List<SmsCouponProductRelation> productRelationList;
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}

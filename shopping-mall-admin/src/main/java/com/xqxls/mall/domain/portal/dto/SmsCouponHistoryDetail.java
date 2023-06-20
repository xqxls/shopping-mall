package com.xqxls.mall.domain.portal.dto;

import com.xqxls.mall.domain.sms.entity.SmsCoupon;
import com.xqxls.mall.domain.sms.entity.SmsCouponHistory;
import com.xqxls.mall.domain.sms.entity.SmsCouponProductCategoryRelation;
import com.xqxls.mall.domain.sms.entity.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 11:34
 * @Description 优惠券领取历史详情（包括优惠券信息和关联关系）
 */
@Getter
@Setter
public class SmsCouponHistoryDetail extends SmsCouponHistory {

    @ApiModelProperty("相关优惠券信息")
    private SmsCoupon coupon;
    @ApiModelProperty("优惠券关联商品")
    private List<SmsCouponProductRelation> productRelationList;
    @ApiModelProperty("优惠券关联商品分类")
    private List<SmsCouponProductCategoryRelation> categoryRelationList;
}

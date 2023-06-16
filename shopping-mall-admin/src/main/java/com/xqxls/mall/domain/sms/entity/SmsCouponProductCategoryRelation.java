package com.xqxls.mall.domain.sms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 优惠券和产品分类关系表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SmsCouponProductCategoryRelation对象", description = "优惠券和产品分类关系表")
@Table(name = "sms_coupon_product_category_relation")
public class SmsCouponProductCategoryRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    /**
     * 产品分类名称
     */
    @Column(name = "product_category_name")
    private String productCategoryName;

    /**
     * 父分类名称
     */
    @Column(name = "parent_category_name")
    private String parentCategoryName;

    private static final long serialVersionUID = 1L;
}
package com.xqxls.mall.domain.sms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 人气推荐商品表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SmsHomeRecommendProduct对象", description = "人气推荐商品表")
@Table(name = "sms_home_recommend_product")
public class SmsHomeRecommendProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "recommend_status")
    private Integer recommendStatus;

    private Integer sort;

    private static final long serialVersionUID = 1L;
}
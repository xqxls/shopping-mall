package com.xqxls.mall.domain.sms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品限时购与商品关系表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SmsFlashPromotionProductRelation对象", description = "商品限时购与商品关系表")
@Table(name = "sms_flash_promotion_product_relation")
public class SmsFlashPromotionProductRelation implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flash_promotion_id")
    private Long flashPromotionId;

    /**
     * 编号
     */
    @Column(name = "flash_promotion_session_id")
    private Long flashPromotionSessionId;

    @Column(name = "product_id")
    private Long productId;

    /**
     * 限时购价格
     */
    @Column(name = "flash_promotion_price")
    private BigDecimal flashPromotionPrice;

    /**
     * 限时购数量
     */
    @Column(name = "flash_promotion_count")
    private Integer flashPromotionCount;

    /**
     * 每人限购数量
     */
    @Column(name = "flash_promotion_limit")
    private Integer flashPromotionLimit;

    /**
     * 排序
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;
}
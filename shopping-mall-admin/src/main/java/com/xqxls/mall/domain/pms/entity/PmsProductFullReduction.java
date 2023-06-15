package com.xqxls.mall.domain.pms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 产品满减表(只针对同商品) 实体
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PmsProductFullReduction对象", description = "产品满减表(只针对同商品)")
@Table(name = "pms_product_full_reduction")
public class PmsProductFullReduction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "full_price")
    private BigDecimal fullPrice;

    @Column(name = "reduce_price")
    private BigDecimal reducePrice;

    private static final long serialVersionUID = 1L;
}
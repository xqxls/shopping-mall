package com.xqxls.mall.domain.pms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 运费模版 实体
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PmsFeightTemplate对象", description = "运费模版")
@Table(name = "pms_feight_template")
public class PmsFeightTemplate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 计费类型:0->按重量；1->按件数
     */
    @Column(name = "charge_type")
    private Integer chargeType;

    /**
     * 首重kg
     */
    @Column(name = "first_weight")
    private BigDecimal firstWeight;

    /**
     * 首费（元）
     */
    @Column(name = "first_fee")
    private BigDecimal firstFee;

    @Column(name = "continue_weight")
    private BigDecimal continueWeight;

    @Column(name = "continme_fee")
    private BigDecimal continmeFee;

    /**
     * 目的地（省、市）
     */
    private String dest;

    private static final long serialVersionUID = 1L;
}
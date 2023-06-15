package com.xqxls.mall.domain.pms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  实体
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PmsProductOperateLog对象", description = "")
@Table(name = "pms_product_operate_log")
public class PmsProductOperateLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price_old")
    private BigDecimal priceOld;

    @Column(name = "price_new")
    private BigDecimal priceNew;

    @Column(name = "sale_price_old")
    private BigDecimal salePriceOld;

    @Column(name = "sale_price_new")
    private BigDecimal salePriceNew;

    /**
     * 赠送的积分
     */
    @Column(name = "gift_point_old")
    private Integer giftPointOld;

    @Column(name = "gift_point_new")
    private Integer giftPointNew;

    @Column(name = "use_point_limit_old")
    private Integer usePointLimitOld;

    @Column(name = "use_point_limit_new")
    private Integer usePointLimitNew;

    /**
     * 操作人
     */
    @Column(name = "operate_man")
    private String operateMan;

    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
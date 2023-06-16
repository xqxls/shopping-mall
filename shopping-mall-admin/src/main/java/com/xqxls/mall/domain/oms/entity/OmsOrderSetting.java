package com.xqxls.mall.domain.oms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 订单设置表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OmsOrderSetting对象", description = "订单设置表")
@Table(name = "oms_order_setting")
public class OmsOrderSetting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    @Column(name = "flash_order_overtime")
    private Integer flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    @Column(name = "normal_order_overtime")
    private Integer normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    @Column(name = "confirm_overtime")
    private Integer confirmOvertime;

    /**
     * 自动完成交易时间，不能申请售后（天）
     */
    @Column(name = "finish_overtime")
    private Integer finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    @Column(name = "comment_overtime")
    private Integer commentOvertime;

    private static final long serialVersionUID = 1L;
}
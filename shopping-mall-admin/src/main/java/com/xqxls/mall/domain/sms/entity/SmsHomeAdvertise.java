package com.xqxls.mall.domain.sms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 首页轮播广告表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SmsHomeAdvertise对象", description = "首页轮播广告表")
@Table(name = "sms_home_advertise")
public class SmsHomeAdvertise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    private Integer type;

    private String pic;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 上下线状态：0->下线；1->上线
     */
    private Integer status;

    /**
     * 点击数
     */
    @Column(name = "click_count")
    private Integer clickCount;

    /**
     * 下单数
     */
    @Column(name = "order_count")
    private Integer orderCount;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 备注
     */
    private String note;

    /**
     * 排序
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;
}
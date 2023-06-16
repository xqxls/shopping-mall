package com.xqxls.mall.domain.sms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 限时购通知记录 实体
 * 
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SmsFlashPromotionLog对象", description = "限时购通知记录")
@Table(name = "sms_flash_promotion_log")
public class SmsFlashPromotionLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "member_phone")
    private String memberPhone;

    @Column(name = "product_name")
    private String productName;

    /**
     * 会员订阅时间
     */
    @Column(name = "subscribe_time")
    private Date subscribeTime;

    @Column(name = "send_time")
    private Date sendTime;

    private static final long serialVersionUID = 1L;
}
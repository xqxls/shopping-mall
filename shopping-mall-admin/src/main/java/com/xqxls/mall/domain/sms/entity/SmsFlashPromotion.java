package com.xqxls.mall.domain.sms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 限时购表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SmsFlashPromotion对象", description = "限时购表")
@Table(name = "sms_flash_promotion")
public class SmsFlashPromotion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 秒杀时间段名称
     */
    private String title;

    /**
     * 开始日期
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 结束日期
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 上下线状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
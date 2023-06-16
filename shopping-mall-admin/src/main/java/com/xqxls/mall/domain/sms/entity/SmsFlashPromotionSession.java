package com.xqxls.mall.domain.sms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 限时购场次表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SmsFlashPromotionSession对象", description = "限时购场次表")
@Table(name = "sms_flash_promotion_session")
public class SmsFlashPromotionSession implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 场次名称
     */
    private String name;

    /**
     * 每日开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 每日结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 启用状态：0->不启用；1->启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
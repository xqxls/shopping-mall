package com.xqxls.mall.domain.portal.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 话题表 实体
 * 
 * @author xqxls
 * @date 2023-06-20 9:49 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CmsTopic对象", description = "话题表")
@Table(name = "cms_topic")
public class CmsTopic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    private String name;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 参与人数
     */
    @Column(name = "attend_count")
    private Integer attendCount;

    /**
     * 关注人数
     */
    @Column(name = "attention_count")
    private Integer attentionCount;

    @Column(name = "read_count")
    private Integer readCount;

    /**
     * 奖品名称
     */
    @Column(name = "award_name")
    private String awardName;

    /**
     * 参与方式
     */
    @Column(name = "attend_type")
    private String attendType;

    /**
     * 话题内容
     */
    private String content;

    private static final long serialVersionUID = 1L;
}
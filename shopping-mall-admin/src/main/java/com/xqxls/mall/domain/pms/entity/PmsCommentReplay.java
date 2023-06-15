package com.xqxls.mall.domain.pms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 产品评价回复表 实体
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PmsCommentReplay对象", description = "产品评价回复表")
@Table(name = "pms_comment_replay")
public class PmsCommentReplay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "member_nick_name")
    private String memberNickName;

    @Column(name = "member_icon")
    private String memberIcon;

    private String content;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    private Integer type;

    private static final long serialVersionUID = 1L;
}
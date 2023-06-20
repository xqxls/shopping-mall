package com.xqxls.mall.domain.portal.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 会员等级表 实体
 * 
 * @author xqxls
 * @date 2023-06-20 9:49 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UmsMemberLevel对象", description = "会员等级表")
@Table(name = "ums_member_level")
public class UmsMemberLevel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "growth_point")
    private Integer growthPoint;

    /**
     * 是否为默认等级：0->不是；1->是
     */
    @Column(name = "default_status")
    private Integer defaultStatus;

    /**
     * 免运费标准
     */
    @Column(name = "free_freight_point")
    private BigDecimal freeFreightPoint;

    /**
     * 每次评价获取的成长值
     */
    @Column(name = "comment_growth_point")
    private Integer commentGrowthPoint;

    /**
     * 是否有免邮特权
     */
    @Column(name = "priviledge_free_freight")
    private Integer priviledgeFreeFreight;

    /**
     * 是否有签到特权
     */
    @Column(name = "priviledge_sign_in")
    private Integer priviledgeSignIn;

    /**
     * 是否有评论获奖励特权
     */
    @Column(name = "priviledge_comment")
    private Integer priviledgeComment;

    /**
     * 是否有专享活动特权
     */
    @Column(name = "priviledge_promotion")
    private Integer priviledgePromotion;

    /**
     * 是否有会员价格特权
     */
    @Column(name = "priviledge_member_price")
    private Integer priviledgeMemberPrice;

    /**
     * 是否有生日特权
     */
    @Column(name = "priviledge_birthday")
    private Integer priviledgeBirthday;

    private String note;

    private static final long serialVersionUID = 1L;
}
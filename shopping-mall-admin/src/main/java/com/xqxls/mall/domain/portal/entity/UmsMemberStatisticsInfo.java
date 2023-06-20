package com.xqxls.mall.domain.portal.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员统计信息 实体
 * 
 * @author xqxls
 * @date 2023-06-20 9:49 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UmsMemberStatisticsInfo对象", description = "会员统计信息")
@Table(name = "ums_member_statistics_info")
public class UmsMemberStatisticsInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    /**
     * 累计消费金额
     */
    @Column(name = "consume_amount")
    private BigDecimal consumeAmount;

    /**
     * 订单数量
     */
    @Column(name = "order_count")
    private Integer orderCount;

    /**
     * 优惠券数量
     */
    @Column(name = "coupon_count")
    private Integer couponCount;

    /**
     * 评价数
     */
    @Column(name = "comment_count")
    private Integer commentCount;

    /**
     * 退货数量
     */
    @Column(name = "return_order_count")
    private Integer returnOrderCount;

    /**
     * 登录次数
     */
    @Column(name = "login_count")
    private Integer loginCount;

    /**
     * 关注数量
     */
    @Column(name = "attend_count")
    private Integer attendCount;

    /**
     * 粉丝数量
     */
    @Column(name = "fans_count")
    private Integer fansCount;

    @Column(name = "collect_product_count")
    private Integer collectProductCount;

    @Column(name = "collect_subject_count")
    private Integer collectSubjectCount;

    @Column(name = "collect_topic_count")
    private Integer collectTopicCount;

    @Column(name = "collect_comment_count")
    private Integer collectCommentCount;

    @Column(name = "invite_friend_count")
    private Integer inviteFriendCount;

    /**
     * 最后一次下订单时间
     */
    @Column(name = "recent_order_time")
    private Date recentOrderTime;

    private static final long serialVersionUID = 1L;
}
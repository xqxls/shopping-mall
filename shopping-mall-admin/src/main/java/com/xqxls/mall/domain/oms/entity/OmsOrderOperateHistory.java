package com.xqxls.mall.domain.oms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单操作历史记录 实体
 * 
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OmsOrderOperateHistory对象", description = "订单操作历史记录")
@Table(name = "oms_order_operate_history")
public class OmsOrderOperateHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 操作人：用户；系统；后台管理员
     */
    @Column(name = "operate_man")
    private String operateMan;

    /**
     * 操作时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 备注
     */
    private String note;

    private static final long serialVersionUID = 1L;
}
package com.xqxls.mall.domain.oms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 退货原因表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OmsOrderReturnReason对象", description = "退货原因表")
@Table(name = "oms_order_return_reason")
public class OmsOrderReturnReason implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 退货类型
     */
    private String name;

    private Integer sort;

    /**
     * 状态：0->不启用；1->启用
     */
    private Integer status;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
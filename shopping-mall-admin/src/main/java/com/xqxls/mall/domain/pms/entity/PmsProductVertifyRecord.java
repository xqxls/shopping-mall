package com.xqxls.mall.domain.pms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品审核记录 实体
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PmsProductVertifyRecord对象", description = "商品审核记录")
@Table(name = "pms_product_vertify_record")
public class PmsProductVertifyRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 审核人
     */
    @Column(name = "vertify_man")
    private String vertifyMan;

    private Integer status;

    /**
     * 反馈详情
     */
    private String detail;

    private static final long serialVersionUID = 1L;
}
package com.xqxls.mall.domain.oms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 公司收发货地址表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OmsCompanyAddress对象", description = "公司收发货地址表")
@Table(name = "oms_company_address")
public class OmsCompanyAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 地址名称
     */
    @Column(name = "address_name")
    private String addressName;

    /**
     * 默认发货地址：0->否；1->是
     */
    @Column(name = "send_status")
    private Integer sendStatus;

    /**
     * 是否默认收货地址：0->否；1->是
     */
    @Column(name = "receive_status")
    private Integer receiveStatus;

    /**
     * 收发货人姓名
     */
    private String name;

    /**
     * 收货人电话
     */
    private String phone;

    /**
     * 省/直辖市
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 详细地址
     */
    @Column(name = "detail_address")
    private String detailAddress;

    private static final long serialVersionUID = 1L;
}
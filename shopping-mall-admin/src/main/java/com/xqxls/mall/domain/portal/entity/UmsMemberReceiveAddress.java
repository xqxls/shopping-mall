package com.xqxls.mall.domain.portal.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 会员收货地址表 实体
 * 
 * @author xqxls
 * @date 2023-06-20 9:49 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UmsMemberReceiveAddress对象", description = "会员收货地址表")
@Table(name = "ums_member_receive_address")
public class UmsMemberReceiveAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    /**
     * 收货人名称
     */
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 是否为默认
     */
    @Column(name = "default_status")
    private Integer defaultStatus;

    /**
     * 邮政编码
     */
    @Column(name = "post_code")
    private String postCode;

    /**
     * 省份/直辖市
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 详细地址(街道)
     */
    @Column(name = "detail_address")
    private String detailAddress;

    private static final long serialVersionUID = 1L;
}
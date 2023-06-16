package com.xqxls.mall.domain.oms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车表 实体
 * 
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OmsCartItem对象", description = "购物车表")
@Table(name = "oms_cart_item")
public class OmsCartItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_sku_id")
    private Long productSkuId;

    @Column(name = "member_id")
    private Long memberId;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 添加到购物车的价格
     */
    private BigDecimal price;

    /**
     * 商品主图
     */
    @Column(name = "product_pic")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品副标题（卖点）
     */
    @Column(name = "product_sub_title")
    private String productSubTitle;

    /**
     * 商品sku条码
     */
    @Column(name = "product_sku_code")
    private String productSkuCode;

    /**
     * 会员昵称
     */
    @Column(name = "member_nickname")
    private String memberNickname;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "modify_date")
    private Date modifyDate;

    /**
     * 是否删除
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * 商品分类
     */
    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_sn")
    private String productSn;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    @Column(name = "product_attr")
    private String productAttr;

    private static final long serialVersionUID = 1L;
}
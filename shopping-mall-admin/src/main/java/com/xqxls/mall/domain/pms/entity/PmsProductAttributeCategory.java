package com.xqxls.mall.domain.pms.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 产品属性分类表 实体
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PmsProductAttributeCategory对象", description = "产品属性分类表")
@Table(name = "pms_product_attribute_category")
public class PmsProductAttributeCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 属性数量
     */
    @Column(name = "attribute_count")
    private Integer attributeCount;

    /**
     * 参数数量
     */
    @Column(name = "param_count")
    private Integer paramCount;

    private static final long serialVersionUID = 1L;
}
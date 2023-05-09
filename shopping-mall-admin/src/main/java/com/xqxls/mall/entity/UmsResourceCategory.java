package com.xqxls.mall.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 资源分类表 实体
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UmsResourceCategory对象", description = "资源分类表")
@Table(name = "ums_resource_category")
public class UmsResourceCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;
}
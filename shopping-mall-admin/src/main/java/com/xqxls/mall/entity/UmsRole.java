package com.xqxls.mall.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台用户角色表 实体
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UmsRole对象", description = "后台用户角色表")
@Table(name = "ums_role")
public class UmsRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 后台用户数量
     */
    @Column(name = "admin_count")
    private Integer adminCount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;

    private Integer sort;

    private static final long serialVersionUID = 1L;
}
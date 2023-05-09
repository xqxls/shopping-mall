package com.xqxls.mall.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台菜单表 实体
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UmsMenu对象", description = "后台菜单表")
@Table(name = "ums_menu")
public class UmsMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父级ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单级数
     */
    private Integer level;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 前端名称
     */
    private String name;

    /**
     * 前端图标
     */
    private String icon;

    /**
     * 前端隐藏
     */
    private Integer hidden;

    private static final long serialVersionUID = 1L;
}
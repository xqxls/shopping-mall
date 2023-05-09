package com.xqxls.mall.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台角色菜单关系表 实体
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UmsRoleMenuRelation对象", description = "后台角色菜单关系表")
@Table(name = "ums_role_menu_relation")
public class UmsRoleMenuRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 菜单ID
     */
    @Column(name = "menu_id")
    private Long menuId;

    private static final long serialVersionUID = 1L;
}
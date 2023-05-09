package com.xqxls.mall.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台用户和角色关系表 实体
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UmsAdminRoleRelation对象", description = "后台用户和角色关系表")
@Table(name = "ums_admin_role_relation")
public class UmsAdminRoleRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "role_id")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}
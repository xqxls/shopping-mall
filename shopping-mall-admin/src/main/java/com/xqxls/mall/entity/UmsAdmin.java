package com.xqxls.mall.entity;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 后台用户表 实体
 * 
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UmsAdmin对象", description = "后台用户表")
@Table(name = "ums_admin")
public class UmsAdmin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}
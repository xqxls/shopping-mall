package com.xqxls.mall.domain.portal.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 专题分类表 实体
 * 
 * @author xqxls
 * @date 2023-06-20 9:49 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CmsSubjectCategory对象", description = "专题分类表")
@Table(name = "cms_subject_category")
public class CmsSubjectCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 分类图标
     */
    private String icon;

    /**
     * 专题数量
     */
    @Column(name = "subject_count")
    private Integer subjectCount;

    @Column(name = "show_status")
    private Integer showStatus;

    private Integer sort;

    private static final long serialVersionUID = 1L;
}
package com.xqxls.mall.domain.pms.entity;

import java.io.Serializable;

/**
 * 商品专题 实体
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public class CmsSubjectProductRelation implements Serializable {
    private Long id;

    private Long subjectId;

    private Long productId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", subjectId=" + subjectId +
                ", productId=" + productId +
                ", serialVersionUID=" + serialVersionUID +
                "]";
    }
}
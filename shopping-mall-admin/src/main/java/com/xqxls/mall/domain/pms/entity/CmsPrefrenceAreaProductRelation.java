package com.xqxls.mall.domain.pms.entity;

import java.io.Serializable;

/**
 * 商品优选 实体
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public class CmsPrefrenceAreaProductRelation implements Serializable {
    private Long id;

    private Long prefrenceAreaId;

    private Long productId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrefrenceAreaId() {
        return prefrenceAreaId;
    }

    public void setPrefrenceAreaId(Long prefrenceAreaId) {
        this.prefrenceAreaId = prefrenceAreaId;
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
                ", prefrenceAreaId=" + prefrenceAreaId +
                ", productId=" + productId +
                ", serialVersionUID=" + serialVersionUID +
                "]";
    }
}
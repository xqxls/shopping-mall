package com.xqxls.mall.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 品牌表 实体
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PmsBrand对象", description = "品牌表")
@Table(name = "pms_brand")
public class PmsBrand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 首字母
     */
    @Column(name = "first_letter")
    private String firstLetter;

    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @Column(name = "factory_status")
    private Integer factoryStatus;

    @Column(name = "show_status")
    private Integer showStatus;

    /**
     * 产品数量
     */
    @Column(name = "product_count")
    private Integer productCount;

    /**
     * 产品评论数量
     */
    @Column(name = "product_comment_count")
    private Integer productCommentCount;

    /**
     * 品牌logo
     */
    private String logo;

    /**
     * 专区大图
     */
    @Column(name = "big_pic")
    private String bigPic;

    /**
     * 品牌故事
     */
    @Column(name = "brand_story")
    private String brandStory;

    private static final long serialVersionUID = 1L;
}
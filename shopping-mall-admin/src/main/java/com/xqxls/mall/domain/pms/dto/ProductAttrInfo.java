package com.xqxls.mall.domain.pms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 胡卓
 * @create 2023-05-10 11:16
 * @Description
 */
@Data
public class ProductAttrInfo {

    @ApiModelProperty("商品属性ID")
    private Long attributeId;

    @ApiModelProperty("商品属性分类ID")
    private Long attributeCategoryId;
}

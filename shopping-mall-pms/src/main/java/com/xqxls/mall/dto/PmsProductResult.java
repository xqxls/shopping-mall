package com.xqxls.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 胡卓
 * @create 2023-05-10 13:36
 * @Description
 */
@Data
public class PmsProductResult extends PmsProductParam{

    @Getter
    @Setter
    @ApiModelProperty("商品所选分类的父id")
    private Long cateParentId;
}

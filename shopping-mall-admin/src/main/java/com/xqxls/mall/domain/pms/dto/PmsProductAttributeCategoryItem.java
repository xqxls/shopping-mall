package com.xqxls.mall.domain.pms.dto;

import com.xqxls.mall.domain.pms.entity.PmsProductAttribute;
import com.xqxls.mall.domain.pms.entity.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author 胡卓
 * @create 2023-05-10 10:51
 * @Description
 */
@Data
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {

    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
}

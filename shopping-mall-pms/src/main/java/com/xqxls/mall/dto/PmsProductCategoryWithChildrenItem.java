package com.xqxls.mall.dto;

import com.xqxls.mall.entity.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author 胡卓
 * @create 2023-05-10 11:32
 * @Description
 */
@Data
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory{

    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<PmsProductCategory> children;
}

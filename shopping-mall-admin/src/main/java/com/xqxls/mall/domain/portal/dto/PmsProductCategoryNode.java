package com.xqxls.mall.domain.portal.dto;

import com.xqxls.mall.domain.pms.entity.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 14:50
 * @Description 包含子分类的商品分类
 */
@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {

    @ApiModelProperty("子分类集合")
    private List<PmsProductCategoryNode> children;
}

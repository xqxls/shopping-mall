package com.xqxls.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 胡卓
 * @create 2023-05-09 15:53
 * @Description
 */
@Data
public class UmsMenuNode {

    @ApiModelProperty(value = "子级菜单")
    private List<UmsMenuNode> children;
}

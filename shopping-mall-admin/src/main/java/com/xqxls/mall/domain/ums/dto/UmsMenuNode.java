package com.xqxls.mall.domain.ums.dto;

import com.xqxls.mall.domain.ums.entity.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 胡卓
 * @create 2023-05-09 15:53
 * @Description
 */
@Data
public class UmsMenuNode extends UmsMenu {

    @ApiModelProperty(value = "子级菜单")
    private List<UmsMenuNode> children;
}

package com.xqxls.mall.domain.oms.dto;

import com.xqxls.mall.domain.oms.entity.OmsCompanyAddress;
import com.xqxls.mall.domain.oms.entity.OmsOrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xqxls
 * @create 2023-06-16 10:19
 * @Description 申请信息封装
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {

    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private OmsCompanyAddress companyAddress;
}

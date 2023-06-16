package com.xqxls.mall.domain.oms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xqxls
 * @create 2023-06-16 13:51
 * @Description 订单发货参数
 */
@Data
public class OmsOrderDeliveryParam {

    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("物流公司")
    private String deliveryCompany;
    @ApiModelProperty("物流单号")
    private String deliverySn;
}

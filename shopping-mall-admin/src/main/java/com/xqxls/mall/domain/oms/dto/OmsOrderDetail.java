package com.xqxls.mall.domain.oms.dto;

import com.xqxls.mall.domain.oms.entity.OmsOrder;
import com.xqxls.mall.domain.oms.entity.OmsOrderItem;
import com.xqxls.mall.domain.oms.entity.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-16 13:51
 * @Description 订单详情信息
 */
public class OmsOrderDetail extends OmsOrder {

    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}

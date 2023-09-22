package com.xqxls.mall.dao;

import com.xqxls.mall.dto.OmsOrderDeliveryParam;
import com.xqxls.mall.dto.OmsOrderDetail;
import com.xqxls.mall.dto.OmsOrderQueryParam;
import com.xqxls.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单查询自定义Dao
 * Created by xqxls on 2018/10/12.
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}

package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.oms.dto.OmsOrderDeliveryParam;
import com.xqxls.mall.domain.oms.dto.OmsOrderDetail;
import com.xqxls.mall.domain.oms.dto.OmsOrderQueryParam;
import com.xqxls.mall.domain.oms.entity.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-16 14:12
 * @Description 订单查询自定义Dao
 */
public interface OmsOrderDetailMapper {

    /**
     * 条件查询订单
     * @param queryParam 查询参数
     * @return 订单列表
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     * @param deliveryParamList 批量发货参数列表
     * @return 成功发货条数
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     * @param id 订单ID
     * @return 订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}

package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.oms.dto.OmsOrderDetail;
import com.xqxls.mall.domain.oms.entity.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 16:46
 * @Description 前台订单管理自定义Dao
 */
public interface PortalOrderMapper {

    /**
     * 获取订单及下单商品详情
     * @param orderId 订单ID
     * @return 订单及下单商品详情
     */
    OmsOrderDetail getDetail(@Param("orderId") Long orderId);

    /**
     * 修改 pms_sku_stock表的锁定库存及真实库存
     * @param orderItemList 订单列表
     * @return 成功修改条数
     */
    int updateSkuStock(@Param("itemList") List<OmsOrderItem> orderItemList);

    /**
     * 获取超时订单
     * @param minute 超时时间（分）
     * @return 超时订单列表
     */
    List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute);

    /**
     * 批量修改订单状态
     * @param ids 订单ID列表
     * @param status 订单状态
     * @return 成功修改条数
     */
    int updateOrderStatus(@Param("ids") List<Long> ids,@Param("status") Integer status);

    /**
     * 解除取消订单的库存锁定
     * @param orderItemList 订单列表
     * @return 成功解除条数
     */
    int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);
}

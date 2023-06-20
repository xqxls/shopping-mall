package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.api.CommonPage;
import com.xqxls.mall.domain.oms.dto.OmsOrderDetail;
import com.xqxls.mall.domain.portal.dto.ConfirmOrderResult;
import com.xqxls.mall.domain.portal.dto.OrderParam;

import java.util.List;
import java.util.Map;

/**
 * @author xqxls
 * @create 2023-06-20 16:31
 * @Description 前台订单管理Service
 */
public interface OmsPortalOrderService {

    /**
     * 根据用户购物车信息生成确认单信息
     * @param cartIds 购物车ID列表
     * @return 确认单信息
     */
    ConfirmOrderResult generateConfirmOrder(List<Long> cartIds);

    /**
     * 根据提交信息生成订单
     * @param orderParam 订单参数
     * @return 订单信息
     */
    Map<String, Object> generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     * @param orderId 订单ID
     * @param payType 订单支付类型
     * @return 成功支付条数
     */
    Integer paySuccess(Long orderId, Integer payType);

    /**
     * 自动取消超时订单
     * @return 成功取消超时订单数
     */
    Integer cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     * @param orderId 订单ID
     */
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     * @param orderId 订单ID
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * 确认收货
     * @param orderId 订单ID
     */
    void confirmReceiveOrder(Long orderId);

    /**
     * 分页获取用户订单
     * @param status 订单状态
     * @param pageNum 当前页
     * @param pageSize 每一页记录数
     * @return 用户订单分页信息
     */
    CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

    /**
     * 根据订单ID获取订单详情
     * @param orderId 订单ID
     * @return 订单详情
     */
    OmsOrderDetail detail(Long orderId);

    /**
     * 用户根据订单ID删除订单
     * @param orderId 订单ID
     */
    void deleteOrder(Long orderId);
}

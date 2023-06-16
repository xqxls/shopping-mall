package com.xqxls.mall.domain.oms.service;

import com.xqxls.mall.domain.oms.dto.*;
import com.xqxls.mall.domain.oms.entity.OmsOrder;
import com.xqxls.mall.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
public interface OmsOrderService extends IService<OmsOrder> {

    /**
     * 订单查询
     * @param queryParam 订单查询参数
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 订单分页信息
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量发货
     * @param deliveryParamList 批量发货参数列表
     * @return 成功发货数量
     */

    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     * @param ids 订单ID列表
     * @param note 订单备注
     * @return 成功关闭订单数量
     */
    int close(List<Long> ids, String note);

    /**
     * 批量删除订单
     * @param ids 订单ID列表
     * @return 成功删除订单数量
     */
    int delete(List<Long> ids);

    /**
     * 获取指定订单详情
     * @param id 订单ID
     * @return 订单详情
     */
    OmsOrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     * @param receiverInfoParam 订单收货人信息
     * @return 成功修改条数
     */
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用信息
     * @param moneyInfoParam 订单费用信息
     * @return 成功修改条数
     */
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     * @param id 订单ID
     * @param note 备注
     * @param status 状态
     * @return 成功修改条数
     */
    int updateNote(Long id, String note, Integer status);
}

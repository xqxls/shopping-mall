package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.entity.SmsCouponHistory;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 优惠券使用、领取历史表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsCouponHistoryService extends IService<SmsCouponHistory> {

    /**
     * 查询优惠券历史分页信息
     * @param couponId 优惠券ID
     * @param useStatus 使用状态
     * @param orderSn 订单号码
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 优惠券历史分页信息
     */
    List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum);
}

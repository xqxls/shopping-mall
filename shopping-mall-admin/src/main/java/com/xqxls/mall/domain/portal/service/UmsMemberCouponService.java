package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.portal.dto.CartPromotionItem;
import com.xqxls.mall.domain.portal.dto.SmsCouponHistoryDetail;
import com.xqxls.mall.domain.sms.entity.SmsCoupon;
import com.xqxls.mall.domain.sms.entity.SmsCouponHistory;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 11:33
 * @Description 用户优惠券管理Service
 */
public interface UmsMemberCouponService {

    /**
     * 会员添加优惠券
     * @param couponId 优惠券ID
     */
    void add(Long couponId);

    /**
     * 获取优惠券历史列表
     * @param useStatus 优惠券使用状态
     * @return 优惠券历史列表
     */
    List<SmsCouponHistory> listHistory(Integer useStatus);

    /**
     * 根据购物车信息获取可用优惠券
     * @param cartItemList 购物车列表
     * @param type 优惠券类型
     * @return 可用优惠券列表
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);

    /**
     * 获取当前商品相关优惠券
     * @param productId 商品ID
     * @return 优惠券列表
     */
    List<SmsCoupon> listByProduct(Long productId);

    /**
     * 获取用户优惠券列表
     * @param useStatus 优惠券使用状态
     * @return 优惠券列表
     */
    List<SmsCoupon> list(Integer useStatus);
}

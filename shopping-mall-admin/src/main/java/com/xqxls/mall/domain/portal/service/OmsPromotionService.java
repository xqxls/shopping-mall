package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.oms.entity.OmsCartItem;
import com.xqxls.mall.domain.portal.dto.CartPromotionItem;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 13:43
 * @Description 促销管理Service
 */
public interface OmsPromotionService {

    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     * @return 促销活动信息
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}

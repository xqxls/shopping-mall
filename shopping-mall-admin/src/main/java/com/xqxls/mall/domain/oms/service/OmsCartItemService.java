package com.xqxls.mall.domain.oms.service;

import com.xqxls.mall.domain.oms.entity.OmsCartItem;
import com.xqxls.mall.domain.portal.dto.CartProduct;
import com.xqxls.mall.domain.portal.dto.CartPromotionItem;
import com.xqxls.mall.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 购物车表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
public interface OmsCartItemService extends IService<OmsCartItem> {

    /**
     * 获取包含促销活动信息的购物车列表
     * @param memberId 会员ID
     * @param cartIds 购物车ID列表
     * @return 包含促销活动信息的购物车列表
     */
    List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds);

    /**
     * 根据会员编号获取购物车列表
     * @param memberId 会员ID
     * @return 购物车列表
     */
    List<OmsCartItem> list(Long memberId);

    /**
     * 查询购物车中是否包含该商品，有增加数量，无添加到购物车
     * @param cartItem 购物车
     * @return 成功添加条数
     */
    int create(OmsCartItem cartItem);

    /**
     * 修改某个购物车商品的数量
     * @param id 购物车ID
     * @param memberId 会员ID
     * @param quantity 商品数量
     * @return 成功修改条数
     */
    int updateQuantity(Long id, Long memberId, Integer quantity);

    /**
     * 批量删除购物车中的商品
     * @param memberId 会员ID
     * @param ids 购物车ID列表
     * @return 成功删除条数
     */
    int delete(Long memberId,List<Long> ids);

    /**
     * 获取购物车中用于选择商品规格的商品信息
     * @param productId 商品ID
     * @return 商品信息
     */
    CartProduct getCartProduct(Long productId);

    /**
     * 修改购物车中商品的规格
     * @param cartItem 购物车
     * @return 成功修改条数
     */
    int updateAttr(OmsCartItem cartItem);

    /**
     * 清空购物车
     * @param memberId 会员ID
     * @return 成功清空条数
     */
    int clear(Long memberId);
}

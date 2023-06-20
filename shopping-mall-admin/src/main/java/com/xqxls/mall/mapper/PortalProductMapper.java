package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.portal.dto.CartProduct;
import com.xqxls.mall.domain.portal.dto.PromotionProduct;
import com.xqxls.mall.domain.sms.entity.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 13:49
 * @Description 前台购物车商品管理自定义Dao
 */
public interface PortalProductMapper {

    /**
     * 获取购物车商品信息
     * @param id 商品ID
     * @return 购物车商品信息
     */
    CartProduct getCartProduct(@Param("id") Long id);

    /**
     * 获取促销商品信息列表
     * @param ids 商品ID列表
     * @return 促销商品信息列表
     */
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);

    /**
     * 获取可用优惠券列表
     * @param productId 商品ID
     * @param productCategoryId 商品分类ID
     * @return 可用优惠券列表
     */
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId, @Param("productCategoryId") Long productCategoryId);
}

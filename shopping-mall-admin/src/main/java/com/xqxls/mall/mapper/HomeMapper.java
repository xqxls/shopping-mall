package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.pms.entity.PmsBrand;
import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.portal.dto.FlashPromotionProduct;
import com.xqxls.mall.domain.portal.entity.CmsSubject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 10:13
 * @Description 首页内容管理自定义Mapper
 */
public interface HomeMapper {

    /**
     * 获取推荐品牌
     * @param offset 截断值
     * @param limit 截断间隔
     * @return 推荐品牌列表
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     * @param flashPromotionId 商品秒杀ID
     * @param sessionId 秒杀场次ID
     * @return 秒杀商品列表
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * 获取新品推荐
     * @param offset 截断值
     * @param limit 截断间隔
     * @return 新品推荐列表
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取人气推荐
     * @param offset 截断值
     * @param limit 截断间隔
     * @return 人气推荐列表
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取推荐专题
     * @param offset 截断值
     * @param limit 截断间隔
     * @return 推荐专题列表
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}

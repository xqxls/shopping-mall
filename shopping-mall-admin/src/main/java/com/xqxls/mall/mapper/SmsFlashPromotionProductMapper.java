package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.sms.dto.SmsFlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-16 16:23
 * @Description
 */
public interface SmsFlashPromotionProductMapper {

    /**
     * 获取限时购及相关商品信息
     */
    List<SmsFlashPromotionProduct> getList(@Param("flashPromotionId") Long flashPromotionId, @Param("flashPromotionSessionId") Long flashPromotionSessionId);
}

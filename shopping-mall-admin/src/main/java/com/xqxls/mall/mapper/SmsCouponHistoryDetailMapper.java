package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.portal.dto.SmsCouponHistoryDetail;
import com.xqxls.mall.domain.sms.entity.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 13:12
 * @Description 会员优惠券领取记录管理自定义Dao
 */
public interface SmsCouponHistoryDetailMapper {

    /**
     * 获取优惠券历史详情
     * @param memberId 会员ID
     * @return 优惠券历史详情
     */
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);

    /**
     *
     * @param memberId 会员ID
     * @param useStatus 优惠券使用状态
     * @return 优惠券列表
     */
    List<SmsCoupon> getCouponList(@Param("memberId") Long memberId, @Param("useStatus")Integer useStatus);
}

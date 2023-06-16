package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.sms.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * @author xqxls
 * @create 2023-06-16 15:41
 * @Description 优惠券管理自定义Dao
 */
public interface SmsCouponParamMapper {

    /**
     * 获取优惠券详情包括绑定关系
     * @param id 优惠券ID
     * @return 优惠券详情
     */
    SmsCouponParam getItem(@Param("id") Long id);
}

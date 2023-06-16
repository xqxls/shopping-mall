package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.dto.SmsCouponParam;
import com.xqxls.mall.domain.sms.entity.SmsCoupon;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 优惠券表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsCouponService extends IService<SmsCoupon> {

    /**
     *
     * @param couponParam
     * @return
     */
    int create(SmsCouponParam couponParam);

    /**
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     *
     * @param id
     * @param couponParam
     * @return
     */
    int update(Long id, SmsCouponParam couponParam);

    /**
     *
     * @param name
     * @param type
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    /**
     *
     * @param id
     * @return
     */
    SmsCouponParam getItem(Long id);
}

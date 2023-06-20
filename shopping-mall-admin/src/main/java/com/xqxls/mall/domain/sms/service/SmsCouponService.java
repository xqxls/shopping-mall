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
     * 添加优惠券
     * @param couponParam 优惠券参数
     * @return 成功添加条数
     */
    int create(SmsCouponParam couponParam);

    /**
     *  根据优惠券id删除优惠券
     * @param id 优惠券ID
     * @return 成功删除条数
     */
    int delete(Long id);

    /**
     *  根据优惠券id更新优惠券信息
     * @param id 优惠券ID
     * @param couponParam 优惠券参数
     * @return 成功更新条数
     */
    int update(Long id, SmsCouponParam couponParam);

    /**
     * 分页获取优惠券列表
     * @param name 优惠券名称
     * @param type 优惠券类型
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 优惠券列表分页信息
     */
    List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 获取优惠券详情
     * @param id 优惠券ID
     * @return 优惠券详情
     */
    SmsCouponParam getItem(Long id);
}

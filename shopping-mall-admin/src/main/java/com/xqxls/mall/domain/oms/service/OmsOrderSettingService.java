package com.xqxls.mall.domain.oms.service;

import com.xqxls.mall.domain.oms.entity.OmsOrderSetting;
import com.xqxls.mall.service.IService;

/**
 * 订单设置表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
public interface OmsOrderSettingService extends IService<OmsOrderSetting> {
    /**
     * 更新订单设置
     * @param id 订单设置ID
     * @param orderSetting 订单设置
     * @return 成功更新条数
     */
    int update(Long id, OmsOrderSetting orderSetting);

}

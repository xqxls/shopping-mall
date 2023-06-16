package com.xqxls.mall.domain.oms.service.impl;

import com.xqxls.mall.domain.oms.entity.OmsOrderSetting;
import com.xqxls.mall.domain.oms.service.OmsOrderSettingService;
import com.xqxls.mall.mapper.OmsOrderSettingMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 订单设置表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Service
public class OmsOrderSettingServiceImpl extends ServiceImpl<OmsOrderSettingMapper, OmsOrderSetting> implements OmsOrderSettingService {

    @Override
    public int update(Long id, OmsOrderSetting orderSetting) {
        orderSetting.setId(id);
        return this.update(orderSetting);
    }
}

package com.xqxls.mall.domain.oms.service.impl;

import com.xqxls.mall.domain.oms.entity.OmsOrderItem;
import com.xqxls.mall.domain.oms.service.OmsOrderItemService;
import com.xqxls.mall.mapper.OmsOrderItemMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 订单中所包含的商品 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements OmsOrderItemService {

}

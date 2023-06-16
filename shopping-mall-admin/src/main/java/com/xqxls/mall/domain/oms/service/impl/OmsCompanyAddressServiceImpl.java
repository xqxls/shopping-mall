package com.xqxls.mall.domain.oms.service.impl;

import com.xqxls.mall.domain.oms.entity.OmsCompanyAddress;
import com.xqxls.mall.domain.oms.service.OmsCompanyAddressService;
import com.xqxls.mall.mapper.OmsCompanyAddressMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公司收发货地址表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Service
public class OmsCompanyAddressServiceImpl extends ServiceImpl<OmsCompanyAddressMapper, OmsCompanyAddress> implements OmsCompanyAddressService {

    @Override
    public List<OmsCompanyAddress> list() {
        return this.findAll();
    }
}

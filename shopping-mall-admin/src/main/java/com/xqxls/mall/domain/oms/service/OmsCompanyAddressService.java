package com.xqxls.mall.domain.oms.service;

import com.xqxls.mall.domain.oms.entity.OmsCompanyAddress;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 公司收发货地址表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
public interface OmsCompanyAddressService extends IService<OmsCompanyAddress> {

    /**
     * 获取全部收货地址
     * @return 全部收货地址
     */
    List<OmsCompanyAddress> list();
}

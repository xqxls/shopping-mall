package com.xqxls.mall.domain.pms.service;

import com.xqxls.mall.domain.pms.entity.PmsSkuStock;
import com.xqxls.mall.service.IService;

import java.util.List;


/**
 * sku的库存 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsSkuStockService extends IService<PmsSkuStock> {

    List<PmsSkuStock> getList(Long pid, String keyword);

    int update(Long pid, List<PmsSkuStock> skuStockList);
}

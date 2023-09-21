package com.xqxls.mall.service;

import com.xqxls.mall.model.PmsSkuStock;

import java.util.List;

/**
 * 商品SKU库存管理Service
 * Created by xqxls on 2018/4/27.
 */
public interface PmsSkuStockService {
    /**
     * 根据产品id和skuCode关键字模糊搜索
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    int update(Long pid, List<PmsSkuStock> skuStockList);
}

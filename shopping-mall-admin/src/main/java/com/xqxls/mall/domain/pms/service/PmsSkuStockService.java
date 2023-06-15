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

    /**
     * 获取商品库存
     * @param pid 父级ID
     * @param keyword 搜索关键词
     * @return 商品库存列表
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * 更新商品库存
     * @param pid 父级ID
     * @param skuStockList 商品库存列表
     * @return 成功更新条数
     */
    int update(Long pid, List<PmsSkuStock> skuStockList);
}

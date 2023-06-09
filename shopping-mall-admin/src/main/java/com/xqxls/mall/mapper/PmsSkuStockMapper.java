package com.xqxls.mall.mapper;

import com.xqxls.mall.base.TkBaseMapper;
import com.xqxls.mall.domain.pms.entity.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sku的库存 Mapper 接口
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsSkuStockMapper extends TkBaseMapper<PmsSkuStock> {

    /**
     * 批量插入或替换操作
     * @param skuStockList 商品库存列表
     * @return 成功插入或替换的条数
     */
    int replaceList(@Param("list") List<PmsSkuStock> skuStockList);
}
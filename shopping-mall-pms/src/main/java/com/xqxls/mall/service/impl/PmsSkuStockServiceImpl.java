package com.xqxls.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.xqxls.mall.service.PmsSkuStockService;
import com.xqxls.mall.entity.PmsSkuStock;
import com.xqxls.mall.mapper.PmsSkuStockMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * sku的库存 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Service
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockMapper, PmsSkuStock> implements PmsSkuStockService {

    @Autowired
    private PmsSkuStockMapper skuStockMapper;

    @Override
    public List<PmsSkuStock> getList(Long pid, String keyword) {
        Example example = new Example(PmsSkuStock.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("productId",pid);
        if (!StrUtil.isEmpty(keyword)) {
            criteria.andLike("skuCode","%" + keyword + "%");
        }
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public int update(Long pid, List<PmsSkuStock> skuStockList) {
        return skuStockMapper.replaceList(skuStockList);
    }
}

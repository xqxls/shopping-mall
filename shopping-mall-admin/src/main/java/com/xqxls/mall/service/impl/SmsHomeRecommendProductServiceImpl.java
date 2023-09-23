package com.xqxls.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.common.exception.Asserts;
import com.xqxls.mall.mapper.SmsHomeRecommendProductMapper;
import com.xqxls.mall.model.SmsHomeNewProduct;
import com.xqxls.mall.model.SmsHomeNewProductExample;
import com.xqxls.mall.model.SmsHomeRecommendProduct;
import com.xqxls.mall.model.SmsHomeRecommendProductExample;
import com.xqxls.mall.service.SmsHomeRecommendProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 首页人气推荐管理Service实现类
 * Created by xqxls on 2018/11/7.
 */
@Service
public class SmsHomeRecommendProductServiceImpl implements SmsHomeRecommendProductService {
    @Autowired
    private SmsHomeRecommendProductMapper recommendProductMapper;
    @Override
    public int create(List<SmsHomeRecommendProduct> homeRecommendProductList) {
        List<Long> ids = homeRecommendProductList.stream().map(SmsHomeRecommendProduct::getProductId).collect(Collectors.toList());
        assertRepeat(ids);
        for (SmsHomeRecommendProduct recommendProduct : homeRecommendProductList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
            recommendProductMapper.insert(recommendProduct);
        }
        return homeRecommendProductList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendProduct recommendProduct = new SmsHomeRecommendProduct();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        return recommendProductMapper.updateByPrimaryKeySelective(recommendProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        example.createCriteria().andIdIn(ids);
        return recommendProductMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeRecommendProduct record = new SmsHomeRecommendProduct();
        record.setRecommendStatus(recommendStatus);
        return recommendProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        SmsHomeRecommendProductExample.Criteria criteria = example.createCriteria();
        if(!StrUtil.isEmpty(productName)){
            criteria.andProductNameLike("%"+productName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return recommendProductMapper.selectByExample(example);
    }

    @Override
    public void assertRepeat(List<Long> ids) {
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        example.createCriteria().andProductIdIn(ids);
        long count = recommendProductMapper.countByExample(example);
        if(count>0){
            Asserts.fail("推荐商品不能重复");
        }
    }
}

package com.xqxls.mall.domain.sms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.sms.entity.SmsHomeRecommendProduct;
import com.xqxls.mall.domain.sms.service.SmsHomeRecommendProductService;
import com.xqxls.mall.mapper.SmsHomeRecommendProductMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 人气推荐商品表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Service
public class SmsHomeRecommendProductServiceImpl extends ServiceImpl<SmsHomeRecommendProductMapper, SmsHomeRecommendProduct> implements SmsHomeRecommendProductService {

    @Autowired
    private SmsHomeRecommendProductMapper recommendProductMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(List<SmsHomeRecommendProduct> homeRecommendProductList) {
        for (SmsHomeRecommendProduct recommendProduct : homeRecommendProductList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
        }
        return recommendProductMapper.insertBatch(homeRecommendProductList);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendProduct recommendProduct = new SmsHomeRecommendProduct();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        return recommendProductMapper.updateByPrimaryKeySelective(recommendProduct);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        Example example = new Example(SmsHomeRecommendProduct.class);
        example.createCriteria().andIn("id",ids);
        SmsHomeRecommendProduct record = new SmsHomeRecommendProduct();
        record.setRecommendStatus(recommendStatus);
        return recommendProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(SmsHomeRecommendProduct.class);
        Example.Criteria criteria = example.createCriteria();
        if(recommendStatus!=null){
            criteria.andEqualTo("recommendStatus",recommendStatus);
        }
        if(!StrUtil.isEmpty(productName)){
            criteria.andLike("productName","%"+productName+"%");
        }
        example.orderBy("sort").desc();
        return recommendProductMapper.selectByExample(example);
    }
}

package com.xqxls.mall.domain.sms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.sms.entity.SmsHomeNewProduct;
import com.xqxls.mall.domain.sms.service.SmsHomeNewProductService;
import com.xqxls.mall.mapper.SmsHomeNewProductMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 新鲜好物表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Service
public class SmsHomeNewProductServiceImpl extends ServiceImpl<SmsHomeNewProductMapper, SmsHomeNewProduct> implements SmsHomeNewProductService {

    @Autowired
    private SmsHomeNewProductMapper homeNewProductMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(List<SmsHomeNewProduct> homeNewProductList) {
        for (SmsHomeNewProduct smsHomeNewProduct : homeNewProductList) {
            smsHomeNewProduct.setRecommendStatus(1);
            smsHomeNewProduct.setSort(0);
        }
        return homeNewProductMapper.insertBatch(homeNewProductList);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeNewProduct homeNewProduct = new SmsHomeNewProduct();
        homeNewProduct.setId(id);
        homeNewProduct.setSort(sort);
        return homeNewProductMapper.updateByPrimaryKeySelective(homeNewProduct);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        Example example = new Example(SmsHomeNewProduct.class);
        example.createCriteria().andIn("id",ids);
        SmsHomeNewProduct record = new SmsHomeNewProduct();
        record.setRecommendStatus(recommendStatus);
        return homeNewProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<SmsHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(SmsHomeNewProduct.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StrUtil.isEmpty(productName)){
            criteria.andLike("productName","%"+productName+"%");
        }
        if(recommendStatus!=null){
            criteria.andEqualTo("recommendStatus",recommendStatus);
        }
        example.orderBy("sort").desc();
        return homeNewProductMapper.selectByExample(example);
    }
}

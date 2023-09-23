package com.xqxls.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.common.exception.Asserts;
import com.xqxls.mall.mapper.SmsHomeBrandMapper;
import com.xqxls.mall.model.SmsHomeBrand;
import com.xqxls.mall.model.SmsHomeBrandExample;
import com.xqxls.mall.service.SmsHomeBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 首页品牌管理Service实现类
 * Created by xqxls on 2018/11/6.
 */
@Service
public class SmsHomeBrandServiceImpl implements SmsHomeBrandService {
    @Autowired
    private SmsHomeBrandMapper homeBrandMapper;
    @Override
    public int create(List<SmsHomeBrand> homeBrandList) {
        List<Long> ids = homeBrandList.stream().map(SmsHomeBrand::getBrandId).collect(Collectors.toList());
        assertRepeat(ids);
        for (SmsHomeBrand smsHomeBrand : homeBrandList) {
            smsHomeBrand.setRecommendStatus(1);
            smsHomeBrand.setSort(0);
            homeBrandMapper.insert(smsHomeBrand);
        }
        return homeBrandList.size();
    }

    public void assertRepeat(List<Long> ids) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andBrandIdIn(ids);
        long count = homeBrandMapper.countByExample(example);
        if(count>0){
            Asserts.fail("推荐品牌不能重复");
        }
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeBrand homeBrand = new SmsHomeBrand();
        homeBrand.setId(id);
        homeBrand.setSort(sort);
        return homeBrandMapper.updateByPrimaryKeySelective(homeBrand);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andIdIn(ids);
        return homeBrandMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeBrand record = new SmsHomeBrand();
        record.setRecommendStatus(recommendStatus);
        return homeBrandMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        SmsHomeBrandExample.Criteria criteria = example.createCriteria();
        if(!StrUtil.isEmpty(brandName)){
            criteria.andBrandNameLike("%"+brandName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return homeBrandMapper.selectByExample(example);
    }
}

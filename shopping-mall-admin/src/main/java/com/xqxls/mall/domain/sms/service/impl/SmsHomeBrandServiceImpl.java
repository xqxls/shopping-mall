package com.xqxls.mall.domain.sms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.sms.entity.SmsHomeBrand;
import com.xqxls.mall.domain.sms.service.SmsHomeBrandService;
import com.xqxls.mall.mapper.SmsHomeBrandMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 首页推荐品牌表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Service
public class SmsHomeBrandServiceImpl extends ServiceImpl<SmsHomeBrandMapper, SmsHomeBrand> implements SmsHomeBrandService {

    @Autowired
    private SmsHomeBrandMapper homeBrandMapper;

    @Override
    public int create(List<SmsHomeBrand> homeBrandList) {
        for (SmsHomeBrand smsHomeBrand : homeBrandList) {
            smsHomeBrand.setRecommendStatus(1);
            smsHomeBrand.setSort(0);
        }
        return homeBrandMapper.insertBatch(homeBrandList);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeBrand homeBrand = new SmsHomeBrand();
        homeBrand.setId(id);
        homeBrand.setSort(sort);
        return homeBrandMapper.updateByPrimaryKeySelective(homeBrand);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        Example example = new Example(SmsHomeBrand.class);
        example.createCriteria().andIn("id",ids);
        SmsHomeBrand record = new SmsHomeBrand();
        record.setRecommendStatus(recommendStatus);
        return homeBrandMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(SmsHomeBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StrUtil.isEmpty(brandName)){
            criteria.andLike("brandName","%"+brandName+"%");
        }
        if(recommendStatus!=null){
            criteria.andEqualTo("recommendStatus",recommendStatus);
        }
        example.orderBy("sort").desc();
        return homeBrandMapper.selectByExample(example);
    }
}

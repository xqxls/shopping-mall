package com.xqxls.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.common.exception.Asserts;
import com.xqxls.mall.mapper.SmsHomeRecommendSubjectMapper;
import com.xqxls.mall.model.SmsHomeRecommendProduct;
import com.xqxls.mall.model.SmsHomeRecommendProductExample;
import com.xqxls.mall.model.SmsHomeRecommendSubject;
import com.xqxls.mall.model.SmsHomeRecommendSubjectExample;
import com.xqxls.mall.service.SmsHomeRecommendSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 首页专题推荐管理Service实现类
 * Created by xqxls on 2018/11/7.
 */
@Service
public class SmsHomeRecommendSubjectServiceImpl implements SmsHomeRecommendSubjectService {
    @Autowired
    private SmsHomeRecommendSubjectMapper smsHomeRecommendSubjectMapper;
    @Override
    public int create(List<SmsHomeRecommendSubject> recommendSubjectList) {
        List<Long> ids = recommendSubjectList.stream().map(SmsHomeRecommendSubject::getSubjectId).collect(Collectors.toList());
        assertRepeat(ids);
        for (SmsHomeRecommendSubject recommendSubject : recommendSubjectList) {
            recommendSubject.setRecommendStatus(1);
            recommendSubject.setSort(0);
            smsHomeRecommendSubjectMapper.insert(recommendSubject);
        }
        return recommendSubjectList.size();
    }

    public void assertRepeat(List<Long> ids) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andSubjectIdIn(ids);
        long count = smsHomeRecommendSubjectMapper.countByExample(example);
        if(count>0){
            Asserts.fail("推荐专题不能重复");
        }
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendSubject recommendSubject = new SmsHomeRecommendSubject();
        recommendSubject.setId(id);
        recommendSubject.setSort(sort);
        return smsHomeRecommendSubjectMapper.updateByPrimaryKeySelective(recommendSubject);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        return smsHomeRecommendSubjectMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeRecommendSubject record = new SmsHomeRecommendSubject();
        record.setRecommendStatus(recommendStatus);
        return smsHomeRecommendSubjectMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        SmsHomeRecommendSubjectExample.Criteria criteria = example.createCriteria();
        if(!StrUtil.isEmpty(subjectName)){
            criteria.andSubjectNameLike("%"+subjectName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return smsHomeRecommendSubjectMapper.selectByExample(example);
    }
}

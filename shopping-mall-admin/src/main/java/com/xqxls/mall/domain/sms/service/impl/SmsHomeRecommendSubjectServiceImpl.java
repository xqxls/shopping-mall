package com.xqxls.mall.domain.sms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.sms.entity.SmsHomeRecommendSubject;
import com.xqxls.mall.domain.sms.service.SmsHomeRecommendSubjectService;
import com.xqxls.mall.mapper.SmsHomeRecommendSubjectMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 首页推荐专题表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Service
public class SmsHomeRecommendSubjectServiceImpl extends ServiceImpl<SmsHomeRecommendSubjectMapper, SmsHomeRecommendSubject> implements SmsHomeRecommendSubjectService {

    @Autowired
    private SmsHomeRecommendSubjectMapper smsHomeRecommendSubjectMapper;

    @Override
    public int create(List<SmsHomeRecommendSubject> homeRecommendSubjectList) {
        for (SmsHomeRecommendSubject recommendSubject : homeRecommendSubjectList) {
            recommendSubject.setRecommendStatus(1);
            recommendSubject.setSort(0);
        }
        return smsHomeRecommendSubjectMapper.insertBatch(homeRecommendSubjectList);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendSubject recommendSubject = new SmsHomeRecommendSubject();
        recommendSubject.setId(id);
        recommendSubject.setSort(sort);
        return smsHomeRecommendSubjectMapper.updateByPrimaryKeySelective(recommendSubject);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        Example example = new Example(SmsHomeRecommendSubject.class);
        example.createCriteria().andIn("id",ids);
        SmsHomeRecommendSubject record = new SmsHomeRecommendSubject();
        record.setRecommendStatus(recommendStatus);
        return smsHomeRecommendSubjectMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(SmsHomeRecommendSubject.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StrUtil.isEmpty(subjectName)){
            criteria.andLike("subjectName","%"+subjectName+"%");
        }
        if(recommendStatus!=null){
            criteria.andEqualTo("recommendStatus",recommendStatus);
        }
        example.orderBy("sort").desc();
        return smsHomeRecommendSubjectMapper.selectByExample(example);
    }
}

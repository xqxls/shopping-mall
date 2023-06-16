package com.xqxls.mall.domain.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.sms.dto.SmsFlashPromotionProduct;
import com.xqxls.mall.domain.sms.entity.SmsFlashPromotionProductRelation;
import com.xqxls.mall.domain.sms.service.SmsFlashPromotionProductRelationService;
import com.xqxls.mall.mapper.SmsFlashPromotionProductMapper;
import com.xqxls.mall.mapper.SmsFlashPromotionProductRelationMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 商品限时购与商品关系表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Service
public class SmsFlashPromotionProductRelationServiceImpl extends ServiceImpl<SmsFlashPromotionProductRelationMapper, SmsFlashPromotionProductRelation> implements SmsFlashPromotionProductRelationService {

    @Autowired
    private SmsFlashPromotionProductRelationMapper relationMapper;

    @Autowired
    private SmsFlashPromotionProductMapper smsFlashPromotionProductMapper;

    @Override
    public int create(List<SmsFlashPromotionProductRelation> relationList) {
        return relationMapper.insertBatch(relationList);
    }

    @Override
    public List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return smsFlashPromotionProductMapper.getList(flashPromotionId,flashPromotionSessionId);
    }

    @Override
    public long getCount(Long flashPromotionId, Long flashPromotionSessionId) {
        Example example = new Example(SmsFlashPromotionProductRelation.class);
        example.createCriteria()
                .andEqualTo("flashPromotionId",flashPromotionId)
                .andEqualTo("flashPromotionSessionId",flashPromotionSessionId);
        return relationMapper.selectCountByExample(example);
    }
}

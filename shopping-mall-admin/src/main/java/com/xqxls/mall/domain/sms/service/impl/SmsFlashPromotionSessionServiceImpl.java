package com.xqxls.mall.domain.sms.service.impl;

import com.xqxls.mall.domain.sms.dto.SmsFlashPromotionSessionDetail;
import com.xqxls.mall.domain.sms.entity.SmsFlashPromotionSession;
import com.xqxls.mall.domain.sms.enums.EnableEnum;
import com.xqxls.mall.domain.sms.service.SmsFlashPromotionProductRelationService;
import com.xqxls.mall.domain.sms.service.SmsFlashPromotionSessionService;
import com.xqxls.mall.mapper.SmsFlashPromotionSessionMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 限时购场次表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Service
public class SmsFlashPromotionSessionServiceImpl extends ServiceImpl<SmsFlashPromotionSessionMapper, SmsFlashPromotionSession> implements SmsFlashPromotionSessionService {

    @Autowired
    private SmsFlashPromotionSessionMapper promotionSessionMapper;

    @Autowired
    private SmsFlashPromotionProductRelationService relationService;

    @Override
    public int updateStatus(Long id, Integer status) {
        SmsFlashPromotionSession promotionSession = new SmsFlashPromotionSession();
        promotionSession.setId(id);
        promotionSession.setStatus(status);
        return this.update(promotionSession);
    }

    @Override
    public List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        List<SmsFlashPromotionSessionDetail> result = new ArrayList<>();
        Example example = new Example(SmsFlashPromotionSession.class);
        example.createCriteria().andEqualTo("status", EnableEnum.YES.getCode());
        List<SmsFlashPromotionSession> list = promotionSessionMapper.selectByExample(example);
        for (SmsFlashPromotionSession promotionSession : list) {
            SmsFlashPromotionSessionDetail detail = new SmsFlashPromotionSessionDetail();
            BeanUtils.copyProperties(promotionSession, detail);
            long count = relationService.getCount(flashPromotionId, promotionSession.getId());
            detail.setProductCount(count);
            result.add(detail);
        }
        return result;
    }
}

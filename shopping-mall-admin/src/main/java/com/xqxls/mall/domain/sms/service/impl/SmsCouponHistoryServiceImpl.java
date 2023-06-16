package com.xqxls.mall.domain.sms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.sms.entity.SmsCouponHistory;
import com.xqxls.mall.domain.sms.service.SmsCouponHistoryService;
import com.xqxls.mall.mapper.SmsCouponHistoryMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 优惠券使用、领取历史表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Service
public class SmsCouponHistoryServiceImpl extends ServiceImpl<SmsCouponHistoryMapper, SmsCouponHistory> implements SmsCouponHistoryService {

    @Autowired
    private SmsCouponHistoryMapper historyMapper;

    @Override
    public List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(SmsCouponHistory.class);
        Example.Criteria criteria = example.createCriteria();
        if(couponId!=null){
            criteria.andEqualTo("couponId",couponId);
        }
        if(useStatus!=null){
            criteria.andEqualTo("useStatus",useStatus);
        }
        if(!StrUtil.isEmpty(orderSn)){
            criteria.andEqualTo("orderSn",orderSn);
        }
        return historyMapper.selectByExample(example);
    }
}

package com.xqxls.mall.domain.portal.service.impl;

import com.xqxls.mall.domain.oms.entity.OmsOrderReturnApply;
import com.xqxls.mall.domain.portal.dto.OmsOrderReturnApplyParam;
import com.xqxls.mall.domain.portal.service.OmsPortalOrderReturnApplyService;
import com.xqxls.mall.mapper.OmsOrderReturnApplyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author xqxls
 * @create 2023-06-20 15:52
 * @Description 订单退货管理Service实现类
 */
@Service
public class OmsPortalOrderReturnApplyServiceImpl implements OmsPortalOrderReturnApplyService {

    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;

    @Override
    public int create(OmsOrderReturnApplyParam returnApply) {
        OmsOrderReturnApply realApply = new OmsOrderReturnApply();
        BeanUtils.copyProperties(returnApply,realApply);
        realApply.setCreateTime(new Date());
        realApply.setStatus(0);
        return returnApplyMapper.insert(realApply);
    }
}

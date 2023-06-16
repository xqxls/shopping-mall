package com.xqxls.mall.domain.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.oms.dto.OmsOrderReturnApplyResult;
import com.xqxls.mall.domain.oms.dto.OmsReturnApplyQueryParam;
import com.xqxls.mall.domain.oms.dto.OmsUpdateStatusParam;
import com.xqxls.mall.domain.oms.entity.OmsOrderReturnApply;
import com.xqxls.mall.domain.oms.enums.ReturnApplyStatusEnum;
import com.xqxls.mall.domain.oms.service.OmsOrderReturnApplyService;
import com.xqxls.mall.mapper.OmsOrderReturnApplyMapper;
import com.xqxls.mall.mapper.OmsOrderReturnApplyResultMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 订单退货申请 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Service
public class OmsOrderReturnApplyServiceImpl extends ServiceImpl<OmsOrderReturnApplyMapper, OmsOrderReturnApply> implements OmsOrderReturnApplyService {

    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;

    @Autowired
    private OmsOrderReturnApplyResultMapper returnApplyResultMapper;

    @Override
    public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return returnApplyResultMapper.getList(queryParam);
    }

    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(OmsOrderReturnApply.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        criteria.andEqualTo("status", ReturnApplyStatusEnum.HAVE_REFUSE.getCode());
        return returnApplyMapper.deleteByExample(example);
    }

    @Override
    public OmsOrderReturnApplyResult getItem(Long id) {
        return returnApplyResultMapper.getDetail(id);
    }

    @Override
    public int updateStatus(Long id, OmsUpdateStatusParam statusParam) {
        Integer status = statusParam.getStatus();
        OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
        if(status.equals(ReturnApplyStatusEnum.RETURN_GOODS.getCode())){
            //确认退货
            returnApply.setId(id);
            returnApply.setStatus(status);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else if(status.equals(ReturnApplyStatusEnum.HAVE_COMPLETE.getCode())){
            //完成退货
            returnApply.setId(id);
            returnApply.setStatus(status);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
        }else if(status.equals(ReturnApplyStatusEnum.HAVE_REFUSE.getCode())){
            //拒绝退货
            returnApply.setId(id);
            returnApply.setStatus(status);
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else{
            return 0;
        }
        return returnApplyMapper.updateByPrimaryKeySelective(returnApply);
    }
}

package com.xqxls.mall.domain.oms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.oms.entity.OmsOrderReturnReason;
import com.xqxls.mall.domain.oms.enums.EnableEnum;
import com.xqxls.mall.domain.oms.service.OmsOrderReturnReasonService;
import com.xqxls.mall.domain.pms.entity.PmsBrand;
import com.xqxls.mall.mapper.OmsOrderReturnReasonMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 退货原因表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Service
public class OmsOrderReturnReasonServiceImpl extends ServiceImpl<OmsOrderReturnReasonMapper, OmsOrderReturnReason> implements OmsOrderReturnReasonService {

    @Autowired
    private OmsOrderReturnReasonMapper returnReasonMapper;

    @Override
    public int create(OmsOrderReturnReason returnReason) {
        returnReason.setCreateTime(new Date());
        return this.add(returnReason);
    }

    @Override
    public int update(Long id, OmsOrderReturnReason returnReason) {
        returnReason.setId(id);
        return this.update(returnReason);
    }

    @Override
    public int delete(List<Long> ids) {
        return this.deleteByIdList(ids);
    }

    @Override
    public List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(OmsOrderReturnReason.class);
        example.orderBy("sort").desc();
        return returnReasonMapper.selectByExample(example);
    }

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        if(!status.equals(EnableEnum.NO.getCode())&&!status.equals(EnableEnum.YES.getCode())){
            return 0;
        }
        OmsOrderReturnReason record = new OmsOrderReturnReason();
        record.setStatus(status);
        Example example = new Example(OmsOrderReturnReason.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return returnReasonMapper.updateByExampleSelective(record,example);
    }
}

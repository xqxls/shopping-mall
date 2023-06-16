package com.xqxls.mall.domain.oms.service;

import com.xqxls.mall.domain.oms.dto.OmsOrderReturnApplyResult;
import com.xqxls.mall.domain.oms.dto.OmsReturnApplyQueryParam;
import com.xqxls.mall.domain.oms.dto.OmsUpdateStatusParam;
import com.xqxls.mall.domain.oms.entity.OmsOrderReturnApply;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 订单退货申请 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
public interface OmsOrderReturnApplyService extends IService<OmsOrderReturnApply> {
    /**
     * 查询订单退货申请分页信息
     * @param queryParam 查询参数
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 订单退货申请分页信息
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除订单退货申请
     * @param ids 退货申请ID列表
     * @return 成功删除条数
     */
    int delete(List<Long> ids);

    /**
     * 获取指定申请详情
     * @param id 退货申请ID
     * @return 指定申请详情
     */
    OmsOrderReturnApplyResult getItem(Long id);

    /**
     * 修改指定申请状态
     * @param id 退货申请ID
     * @param statusParam 状态参数
     * @return 成功修改条数
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);
}

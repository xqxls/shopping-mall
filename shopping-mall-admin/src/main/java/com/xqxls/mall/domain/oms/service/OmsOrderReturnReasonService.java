package com.xqxls.mall.domain.oms.service;

import com.xqxls.mall.domain.oms.entity.OmsOrderReturnReason;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 退货原因表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
public interface OmsOrderReturnReasonService extends IService<OmsOrderReturnReason> {

    /**
     * 添加退货原因
     * @param returnReason 退货原因
     * @return 成功添加条数
     */
    int create(OmsOrderReturnReason returnReason);

    /**
     * 修改退货原因
     * @param id 退货原因ID
     * @param returnReason 退货原因
     * @return 成功修改条数
     */
    int update(Long id, OmsOrderReturnReason returnReason);

    /**
     * 删除退货原因
     * @param ids 退货原因ID列表
     * @return 成功删除条数
     */
    int delete(List<Long> ids);

    /**
     * 分页获取退货原因
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 退货原因分页信息
     */
    List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);

    /**
     * 批量修改退货原因状态
     * @param ids 退货原因ID列表
     * @param status 退货原因状态
     * @return 成功修改条数
     */
    int updateStatus(List<Long> ids, Integer status);
}

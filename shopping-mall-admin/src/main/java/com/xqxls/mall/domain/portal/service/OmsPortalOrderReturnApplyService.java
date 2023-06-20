package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.portal.dto.OmsOrderReturnApplyParam;

/**
 * @author xqxls
 * @create 2023-06-20 15:50
 * @Description 前台订单退货管理Service
 */
public interface OmsPortalOrderReturnApplyService {

    /**
     * 提交申请
     * @param returnApply 退货申请请求参数
     * @return 成功添加条数
     */
    int create(OmsOrderReturnApplyParam returnApply);
}

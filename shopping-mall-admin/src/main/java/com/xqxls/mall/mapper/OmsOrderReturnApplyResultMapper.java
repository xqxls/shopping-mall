package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.oms.dto.OmsOrderReturnApplyResult;
import com.xqxls.mall.domain.oms.dto.OmsReturnApplyQueryParam;
import com.xqxls.mall.domain.oms.entity.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-16 11:56
 * @Description 订单退货申请自定义Dao
 */
public interface OmsOrderReturnApplyResultMapper {

    /**
     * 查询申请列表
     * @param queryParam 查询参数
     * @return 申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     * @param id 退货申请ID
     * @return 申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}

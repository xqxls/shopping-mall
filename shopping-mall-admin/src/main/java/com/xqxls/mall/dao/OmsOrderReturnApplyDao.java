package com.xqxls.mall.dao;

import com.xqxls.mall.dto.OmsOrderReturnApplyResult;
import com.xqxls.mall.dto.OmsReturnApplyQueryParam;
import com.xqxls.mall.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请管理自定义Dao
 * Created by xqxls on 2018/10/18.
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id") Long id);
}

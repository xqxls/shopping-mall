package com.xqxls.mall.service;

import com.xqxls.mall.dto.PmsProductParam;
import com.xqxls.mall.dto.PmsProductQueryParam;
import com.xqxls.mall.dto.PmsProductResult;
import com.xqxls.mall.entity.PmsProduct;

import java.util.List;


/**
 * 商品信息 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsProductService extends IService<PmsProduct> {

    int create(PmsProductParam productParam);

    PmsProductResult getUpdateInfo(Long id);

    int update(Long id, PmsProductParam productParam);

    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    List<PmsProduct> list(String keyword);

    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    int updateNewStatus(List<Long> ids, Integer newStatus);

    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);
}

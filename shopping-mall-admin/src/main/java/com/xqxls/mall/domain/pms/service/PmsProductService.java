package com.xqxls.mall.domain.pms.service;

import com.xqxls.mall.domain.pms.dto.PmsProductParam;
import com.xqxls.mall.domain.pms.dto.PmsProductQueryParam;
import com.xqxls.mall.domain.pms.dto.PmsProductResult;
import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.service.IService;

import java.util.List;


/**
 * 商品信息 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsProductService extends IService<PmsProduct> {

    /**
     * 新增商品
     * @param productParam 商品参数
     * @return 成功新增条数
     */
    int create(PmsProductParam productParam);

    /**
     * 根据商品ID获取商品更新信息
     * @param id 商品ID
     * @return 商品更新信息
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * 更新商品
     * @param id 商品ID
     * @param productParam 商品参数
     * @return 成功更新条数
     */
    int update(Long id, PmsProductParam productParam);

    /**
     * 分页查询商品
     * @param productQueryParam 商品查询参数
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 商品分页信息
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 按关键词查询商品
     * @param keyword 搜索关键词
     * @return 商品列表
     */
    List<PmsProduct> list(String keyword);

    /**
     * 更新商品
     * @param ids 商品ID列表
     * @param verifyStatus 审核状态
     * @param detail 反馈详情
     * @return 成功更新条数
     */
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 更新商品
     * @param ids 商品ID列表
     * @param publishStatus 上架状态
     * @return 成功更新条数
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 更新商品
     * @param ids 商品ID列表
     * @param recommendStatus 推荐状态
     * @return 成功更新条数
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 更新商品
     * @param ids 商品ID列表
     * @param newStatus 新品状态
     * @return 成功更新条数
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 更新商品
     * @param ids 商品ID列表
     * @param deleteStatus 删除状态
     * @return 成功更新条数
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);
}

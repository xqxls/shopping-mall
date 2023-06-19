package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.entity.SmsHomeRecommendProduct;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 人气推荐商品表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsHomeRecommendProductService extends IService<SmsHomeRecommendProduct> {

    /**
     * 添加人气推荐商品
     * @param homeRecommendProductList 人气推荐商品列表
     * @return 成功添加条数
     */
    int create(List<SmsHomeRecommendProduct> homeRecommendProductList);

    /**
     * 修改人气推荐商品排序
     * @param id 人气推荐商品ID
     * @param sort 人气推荐商品排序
     * @return 成功修改条数
     */
    int updateSort(Long id, Integer sort);

    /**
     * 修改人气推荐商品状态
     * @param ids 人气推荐商品ID列表
     * @param recommendStatus 人气推荐商品状态
     * @return 成功修改条数
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询人气推荐商品
     * @param productName 产品名称
     * @param recommendStatus 推荐状态
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 人气推荐商品分页信息
     */
    List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}

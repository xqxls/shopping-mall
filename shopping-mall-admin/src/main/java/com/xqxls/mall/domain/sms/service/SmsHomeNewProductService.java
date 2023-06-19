package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.entity.SmsHomeNewProduct;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 新鲜好物表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsHomeNewProductService extends IService<SmsHomeNewProduct> {

    /**
     * 添加首页推荐
     * @param homeNewProductList 首页推荐列表
     * @return 成功添加条数
     */
    int create(List<SmsHomeNewProduct> homeNewProductList);

    /**
     * 修改首页推荐
     * @param id 首页推荐ID
     * @param sort 排序
     * @return 成功修改条数
     */
    int updateSort(Long id, Integer sort);

    /**
     * 修改首页推荐状态
     * @param ids 首页推荐ID列表
     * @param recommendStatus 推荐状态
     * @return 成功修改条数
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询推荐
     * @param productName 产品名称
     * @param recommendStatus 推荐状态
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 首页推荐分页信息
     */
    List<SmsHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}

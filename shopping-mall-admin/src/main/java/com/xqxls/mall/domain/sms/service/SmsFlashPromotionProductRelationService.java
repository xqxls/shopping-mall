package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.dto.SmsFlashPromotionProduct;
import com.xqxls.mall.domain.sms.entity.SmsFlashPromotionProductRelation;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 商品限时购与商品关系表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsFlashPromotionProductRelationService extends IService<SmsFlashPromotionProductRelation> {

    /**
     * 批量添加关联
     * @param relationList  商品限时购与商品关系列表
     * @return 成功新增条数
     */
    int create(List<SmsFlashPromotionProductRelation> relationList);

    /**
     * 分页查询相关商品及限时购促销信息
     * @param flashPromotionId 限时购id
     * @param flashPromotionSessionId 限时购场次id
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 相关商品及限时购促销信息分页信息
     */
    List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum);

    /**
     * 根据活动和场次id获取商品关系数量
     * @param flashPromotionId        限时购id
     * @param flashPromotionSessionId 限时购场次id
     * @return 商品关系数量
     */
    long getCount(Long flashPromotionId,Long flashPromotionSessionId);
}

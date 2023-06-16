package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.entity.SmsFlashPromotion;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 限时购表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsFlashPromotionService extends IService<SmsFlashPromotion> {

    /**
     * 添加活动
     * @param flashPromotion 活动信息
     * @return 成功添加条数
     */
    int create(SmsFlashPromotion flashPromotion);

    /**
     * 修改指定活动
     * @param id 活动ID
     * @param flashPromotion 活动信息
     * @return 成功修改条数
     */
    int update(Long id, SmsFlashPromotion flashPromotion);

    /**
     * 删除单个活动
     * @param id 活动ID
     * @return 成功删除条数
     */
    int delete(Long id);

    /**
     * 修改上下线状态
     * @param id 活动ID
     * @param status 活动状态
     * @return 成功修改条数
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取活动详情
     * @param id 活动ID
     * @return 活动详情
     */
    SmsFlashPromotion getItem(Long id);

    /**
     * 分页查询活动
     * @param keyword 搜索关键词
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 活动分页信息
     */
    List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);


}

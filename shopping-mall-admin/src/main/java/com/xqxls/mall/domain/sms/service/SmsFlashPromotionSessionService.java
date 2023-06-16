package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.dto.SmsFlashPromotionSessionDetail;
import com.xqxls.mall.domain.sms.entity.SmsFlashPromotionSession;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 限时购场次表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsFlashPromotionSessionService extends IService<SmsFlashPromotionSession> {

    /**
     * 修改场次启用状态
     * @param id 场次ID
     * @param status 启用状态
     * @return 成功修改条数
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取全部可选场次及其数量
     * @param flashPromotionId 限时购id
     * @return 可选场次及其数量列表
     */
    List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId);
}

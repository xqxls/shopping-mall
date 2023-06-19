package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.entity.SmsHomeRecommendSubject;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 首页推荐专题表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsHomeRecommendSubjectService extends IService<SmsHomeRecommendSubject> {

    /**
     * 批量添加首页推荐专题
     * @param homeRecommendSubjectList 首页推荐专题列表
     * @return 成功添加条数
     */
    int create(List<SmsHomeRecommendSubject> homeRecommendSubjectList);

    /**
     * 修改首页推荐专题排序
     * @param id 首页推荐专题ID
     * @param sort 排序
     * @return 成功修改条数
     */
    int updateSort(Long id, Integer sort);

    /**
     * 修改首页推荐专题状态
     * @param ids 首页推荐专题ID列表
     * @param recommendStatus 首页推荐专题状态
     * @return 成功修改条数
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询首页推荐专题
     * @param subjectName 专题名称
     * @param recommendStatus 推荐状态
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 首页推荐专题分页信息
     */
    List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum);

}

package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.entity.SmsHomeAdvertise;
import com.xqxls.mall.service.IService;

import java.util.List;

/**
 * 首页轮播广告表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsHomeAdvertiseService extends IService<SmsHomeAdvertise> {

    /**
     * 添加广告
     * @param advertise 广告
     * @return 成功新增条数
     */
    int create(SmsHomeAdvertise advertise);

    /**
     * 修改上、下线状态
     * @param id 广告ID
     * @param status 上、下线状态
     * @return 成功修改条数
     */
    int updateStatus(Long id, Integer status);

    /**
     * 分页查询广告
     * @param name 广告名称
     * @param type 广告类型
     * @param endTime 结束时间
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 广告分页信息
     */
    List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);

}

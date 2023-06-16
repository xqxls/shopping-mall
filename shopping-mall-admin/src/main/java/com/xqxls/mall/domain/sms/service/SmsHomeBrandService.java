package com.xqxls.mall.domain.sms.service;

import com.xqxls.mall.domain.sms.entity.SmsHomeBrand;
import com.xqxls.mall.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页推荐品牌表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
public interface SmsHomeBrandService extends IService<SmsHomeBrand> {

    /**
     * 添加首页品牌推荐
     * @param homeBrandList 首页品牌推荐列表
     * @return 成功新增条数
     */
    int create(List<SmsHomeBrand> homeBrandList);

    /**
     * 修改品牌推荐排序
     * @param id 品牌推荐ID
     * @param sort 品牌推荐排序
     * @return 成功修改条数
     */
    int updateSort(Long id, Integer sort);


    /**
     * 批量更新推荐状态
     * @param ids 品牌推荐ID列表
     * @param recommendStatus 品牌推荐状态
     * @return 成功更新条数
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询品牌推荐
     * @param brandName 品牌推荐名称
     * @param recommendStatus 品牌推荐状态
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 品牌推荐分页信息
     */
    List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}

package com.xqxls.mall.domain.pms.service;

import com.xqxls.mall.domain.pms.dto.PmsBrandParam;
import com.xqxls.mall.domain.pms.entity.PmsBrand;
import com.xqxls.mall.service.IService;

import java.util.List;


/**
 * 品牌表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsBrandService extends IService<PmsBrand> {

    /**
     * 新增品牌
     * @param pmsBrandParam 品牌参数
     * @return 成功新增条数
     */
    int createBrand(PmsBrandParam pmsBrandParam);

    /**
     * 更新品牌
     * @param id 品牌ID
     * @param pmsBrandParam 品牌参数
     * @return 成功更新条数
     */
    int updateBrand(Long id, PmsBrandParam pmsBrandParam);

    /**
     * 查询品牌分页信息
     * @param keyword 搜索关键词
     * @param showStatus 显示状态
     * @param pageNum 当前页
     * @param pageSize 每一页级记录数
     * @return 品牌分页信息
     */
    List<PmsBrand> listBrand(String keyword, Integer showStatus, Integer pageNum, Integer pageSize);

    /**
     * 更新显示状态
     * @param ids 品牌ID列表
     * @param showStatus 显示状态
     * @return 成功更新条数
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 更新是否为品牌制造商状态
     * @param ids 品牌ID列表
     * @param factoryStatus 是否为品牌制造商状态
     * @return 成功更新条数
     */
    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}

package com.xqxls.mall.service;

import com.xqxls.mall.dto.PmsBrandParam;
import com.xqxls.mall.entity.PmsBrand;

import java.util.List;


/**
 * 品牌表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsBrandService extends IService<PmsBrand> {

    int createBrand(PmsBrandParam pmsBrandParam);

    int updateBrand(Long id, PmsBrandParam pmsBrandParam);

    List<PmsBrand> listBrand(String keyword, Integer showStatus, Integer pageNum, Integer pageSize);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}

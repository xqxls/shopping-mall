package com.xqxls.mall.domain.pms.service;

import com.xqxls.mall.domain.pms.dto.PmsProductCategoryParam;
import com.xqxls.mall.domain.pms.dto.PmsProductCategoryWithChildrenItem;
import com.xqxls.mall.domain.pms.entity.PmsProductCategory;
import com.xqxls.mall.service.IService;

import java.util.List;


/**
 * 产品分类 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsProductCategoryService extends IService<PmsProductCategory> {

    int create(PmsProductCategoryParam productCategoryParam);

    int update(Long id, PmsProductCategoryParam productCategoryParam);

    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    int updateNavStatus(List<Long> ids, Integer navStatus);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}

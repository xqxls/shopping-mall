package com.xqxls.mall.service;

import com.xqxls.mall.dto.PmsProductCategoryParam;
import com.xqxls.mall.dto.PmsProductCategoryWithChildrenItem;
import com.xqxls.mall.entity.PmsProductCategory;

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

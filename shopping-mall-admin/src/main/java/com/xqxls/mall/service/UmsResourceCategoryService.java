package com.xqxls.mall.service;

import com.xqxls.mall.entity.UmsResourceCategory;


/**
 * 资源分类表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsResourceCategoryService extends IService<UmsResourceCategory> {

    /**
     * 新增资源分类
     * @param umsResourceCategory 资源分类实体
     * @return 成功新增条数
     */
    int create(UmsResourceCategory umsResourceCategory);
}

package com.xqxls.mall.domain.pms.service;

import com.xqxls.mall.domain.pms.dto.PmsProductAttributeCategoryItem;
import com.xqxls.mall.domain.pms.entity.PmsProductAttributeCategory;
import com.xqxls.mall.service.IService;

import java.util.List;


/**
 * 产品属性分类表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsProductAttributeCategoryService extends IService<PmsProductAttributeCategory> {

    /**
     * 新增商品属性分类
     * @param name 商品属性分类名称
     * @return 成功新增条数
     */
    int create(String name);

    /**
     * 更新商品属性分类
     * @param id 商品属性分类ID
     * @param name 商品属性分类名称
     * @return 成功更新条数
     */
    int update(Long id, String name);

    /**
     * 获取商品属性分类
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 商品属性分类列表
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品属性信息
     * @return 商品属性信息
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}

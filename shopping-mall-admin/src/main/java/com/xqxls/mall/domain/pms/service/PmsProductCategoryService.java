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
    /**
     * 新增商品分类
     * @param productCategoryParam 商品分类参数
     * @return 成功新增条数
     */
    int create(PmsProductCategoryParam productCategoryParam);

    /**
     * 更新商品分类
     * @param id 商品分类ID
     * @param productCategoryParam 商品分类参数
     * @return 成功更新条数
     */
    int update(Long id, PmsProductCategoryParam productCategoryParam);

    /**
     * 获取商品分类分页信息
     * @param parentId 父级ID
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 商品分类分页信息
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 更新商品分类
     * @param ids 商品分类ID列表
     * @param navStatus 是否显示在导航栏
     * @return 成功更新条数
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * 更新商品分类
     * @param ids 商品分类ID列表
     * @param showStatus 显示状态
     * @return 成功更新条数
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 获取商品分类信息
     * @return 商品分类信息列表
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}

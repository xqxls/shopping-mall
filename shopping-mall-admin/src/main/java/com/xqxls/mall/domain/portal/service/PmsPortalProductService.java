package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.portal.dto.PmsPortalProductDetail;
import com.xqxls.mall.domain.portal.dto.PmsProductCategoryNode;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 14:49
 * @Description 前台商品管理Service
 */
public interface PmsPortalProductService {

    /**
     * 综合搜索商品
     * @param keyword 搜索关键词
     * @param brandId 品牌UD
     * @param productCategoryId 商品分类ID
     * @param pageNum 当前页
     * @param pageSize 每一页记录数
     * @param sort 排序
     * @return 商品分页信息
     */
    List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * 以树形结构获取所有商品分类
     * @return 商品分类树形结构
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     * @param id 商品ID
     * @return 前台商品详情
     */
    PmsPortalProductDetail detail(Long id);
}

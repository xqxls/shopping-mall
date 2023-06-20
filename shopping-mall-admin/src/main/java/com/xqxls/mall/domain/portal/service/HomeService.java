package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.pms.entity.PmsProductCategory;
import com.xqxls.mall.domain.portal.dto.HomeContentResult;
import com.xqxls.mall.domain.portal.entity.CmsSubject;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 10:00
 * @Description 首页内容管理Service
 */
public interface HomeService {

    /**
     * 获取首页内容
     * @return 首页内容
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 首页商品推荐分页信息
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     * @return 商品分类列表
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     * @param cateId 专题分类id
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 专题分页信息
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);

    /**
     * 分页获取人气推荐商品
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 人气推荐商品分页信息
     */
    List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize);

    /**
     * 分页获取新品推荐商品
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 新品推荐商品分页信息
     */
    List<PmsProduct> newProductList(Integer pageNum, Integer pageSize);
}

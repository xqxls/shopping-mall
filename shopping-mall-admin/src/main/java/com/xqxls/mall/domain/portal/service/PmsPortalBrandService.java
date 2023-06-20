package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.api.CommonPage;
import com.xqxls.mall.domain.pms.entity.PmsBrand;
import com.xqxls.mall.domain.pms.entity.PmsProduct;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 14:41
 * @Description 前台品牌管理Service
 */
public interface PmsPortalBrandService {

    /**
     * 分页获取推荐品牌
     * @param pageNum 每一页记录数
     * @param pageSize 当前页
     * @return 推荐品牌分页信息
     */
    List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);

    /**
     * 获取品牌详情
     * @param brandId 品牌ID
     * @return 品牌详情
     */
    PmsBrand detail(Long brandId);

    /**
     * 分页获取品牌关联商品
     * @param brandId 品牌ID
     * @param pageNum 每一页记录数
     * @param pageSize 当前页
     * @return 品牌关联商品分页信息
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}

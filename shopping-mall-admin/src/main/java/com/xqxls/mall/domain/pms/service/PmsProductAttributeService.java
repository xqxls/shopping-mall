package com.xqxls.mall.domain.pms.service;

import com.xqxls.mall.domain.pms.dto.PmsProductAttributeParam;
import com.xqxls.mall.domain.pms.dto.ProductAttrInfo;
import com.xqxls.mall.domain.pms.entity.PmsProductAttribute;
import com.xqxls.mall.service.IService;

import java.util.List;


/**
 * 商品属性参数表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsProductAttributeService extends IService<PmsProductAttribute> {

    /**
     * 获取商品属性分页信息
     * @param cid 商品属性分类ID
     * @param type 商品属性类型
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 商品属性分页信息
     */
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 新增商品属性
     * @param productAttributeParam 商品属性参数
     * @return 成功新增条数
     */
    int create(PmsProductAttributeParam productAttributeParam);

    /**
     * 更新商品属性
     * @param id 商品属性ID
     * @param productAttributeParam 商品属性参数
     * @return 成功更新条数
     */
    int update(Long id, PmsProductAttributeParam productAttributeParam);

    /**
     * 通过商品分类ID获取商品信息列表
     * @param productCategoryId 商品分类ID
     * @return 商品信息列表
     */
    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);

    /**
     * 批量删除商品属性
     * @param ids 商品属性ID
     * @return 成功删除条数
     */
    int delete(List<Long> ids);
}

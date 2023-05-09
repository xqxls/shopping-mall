package com.xqxls.mall.service.impl;

import com.xqxls.mall.service.PmsProductCategoryAttributeRelationService;
import com.xqxls.mall.entity.PmsProductCategoryAttributeRelation;
import com.xqxls.mall.mapper.PmsProductCategoryAttributeRelationMapper;

import org.springframework.stereotype.Service;

/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Service
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationMapper, PmsProductCategoryAttributeRelation> implements PmsProductCategoryAttributeRelationService {

}

package com.xqxls.mall.domain.pms.service.impl;

import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.pms.dto.PmsProductCategoryParam;
import com.xqxls.mall.domain.pms.dto.PmsProductCategoryWithChildrenItem;
import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.pms.entity.PmsProductCategory;
import com.xqxls.mall.domain.pms.entity.PmsProductCategoryAttributeRelation;
import com.xqxls.mall.mapper.PmsProductCategoryAttributeRelationMapper;
import com.xqxls.mall.mapper.PmsProductCategoryMapper;
import com.xqxls.mall.mapper.PmsProductCategoryWithChildrenItemMapper;
import com.xqxls.mall.mapper.PmsProductMapper;
import com.xqxls.mall.domain.pms.service.PmsProductCategoryService;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 产品分类 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Service
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements PmsProductCategoryService {

    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;

    @Autowired
    private PmsProductMapper productMapper;

    @Autowired
    private PmsProductCategoryAttributeRelationMapper productCategoryAttributeRelationMapper;

    @Autowired
    private PmsProductCategoryWithChildrenItemMapper pmsProductCategoryWithChildrenItemMapper;


    @Override
    public int create(PmsProductCategoryParam productCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setProductCount(0);
        BeanUtils.copyProperties(productCategoryParam, productCategory);
        //没有父分类时为一级分类
        setCategoryLevel(productCategory);
        int count = this.add(productCategory);
        //创建筛选属性关联
        List<Long> productAttributeIdList = productCategoryParam.getProductAttributeIdList();
        if(!CollectionUtils.isEmpty(productAttributeIdList)){
            insertRelationList(productCategory.getId(), productAttributeIdList);
        }
        return count;
    }

    @Override
    public int update(Long id, PmsProductCategoryParam productCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setId(id);
        BeanUtils.copyProperties(productCategoryParam, productCategory);
        setCategoryLevel(productCategory);
        //更新商品分类时要更新商品中的名称
        PmsProduct product = new PmsProduct();
        product.setProductCategoryName(productCategory.getName());
        Example example = new Example(PmsProduct.class);
        Example.Criteria criteria =  example.createCriteria();
        criteria.andEqualTo("productCategoryId",id);
        productMapper.updateByExampleSelective(product,example);
        //同时更新筛选属性的信息
        if(!CollectionUtils.isEmpty(productCategoryParam.getProductAttributeIdList())){
            Example relationExample = new Example(PmsProductCategoryAttributeRelation.class);
            Example.Criteria relationCriteria =  relationExample.createCriteria();
            relationCriteria.andEqualTo("productCategoryId",id);
            productCategoryAttributeRelationMapper.deleteByExample(relationExample);
            insertRelationList(id,productCategoryParam.getProductAttributeIdList());
        }else{
            Example relationExample = new Example(PmsProductCategoryAttributeRelation.class);
            Example.Criteria relationCriteria =  relationExample.createCriteria();
            relationCriteria.andEqualTo("productCategoryId",id);
            productCategoryAttributeRelationMapper.deleteByExample(relationExample);
        }
        return this.update(productCategory);
    }

    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(PmsProductCategory.class);
        Example.Criteria criteria =  example.createCriteria();
        if(Objects.nonNull(parentId)){
            criteria.andEqualTo("parentId",parentId);
        }
        example.orderBy("sort").desc();
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setNavStatus(navStatus);
        Example example = new Example(PmsProductCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setShowStatus(showStatus);
        Example example = new Example(PmsProductCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return pmsProductCategoryWithChildrenItemMapper.listWithChildren();
    }

    private void setCategoryLevel(PmsProductCategory productCategory) {
        //没有父分类时为一级分类
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            PmsProductCategory parentCategory = productCategoryMapper.selectByPrimaryKey(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }

    private void insertRelationList(Long productCategoryId, List<Long> productAttributeIdList) {
        List<PmsProductCategoryAttributeRelation> relationList = new ArrayList<>();
        for (Long productAttrId : productAttributeIdList) {
            PmsProductCategoryAttributeRelation relation = new PmsProductCategoryAttributeRelation();
            relation.setProductAttributeId(productAttrId);
            relation.setProductCategoryId(productCategoryId);
            relationList.add(relation);
        }
        productCategoryAttributeRelationMapper.insertBatch(relationList);
    }
}

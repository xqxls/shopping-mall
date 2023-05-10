package com.xqxls.mall.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.dto.PmsProductParam;
import com.xqxls.mall.dto.PmsProductQueryParam;
import com.xqxls.mall.dto.PmsProductResult;
import com.xqxls.mall.entity.*;
import com.xqxls.mall.mapper.*;
import com.xqxls.mall.mapstruct.PmsProductConvert;
import com.xqxls.mall.service.PmsProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品信息 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Service
@Slf4j
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {

    @Autowired
    private PmsSkuStockMapper skuStockMapper;

    @Autowired
    private PmsProductMapper productMapper;

    @Autowired
    private PmsMemberPriceMapper memberPriceMapper;

    @Autowired
    private PmsProductLadderMapper productLadderMapper;

    @Autowired
    private PmsProductFullReductionMapper productFullReductionMapper;

    @Autowired
    private PmsProductAttributeValueMapper productAttributeValueMapper;

    @Autowired
    private PmsProductVertifyRecordMapper productVertifyRecordMapper;

    @Autowired
    private CmsSubjectProductRelationMapper subjectProductRelationMapper;

    @Autowired
    private CmsPrefrenceAreaProductRelationMapper prefrenceAreaProductRelationMapper;

    @Autowired
    private PmsProductResultMapper pmsProductResultMapper;

    @Override
    public int create(PmsProductParam productParam){
        //创建商品
        PmsProduct product = PmsProductConvert.INSTANCE.pmsProductParamToEntity(productParam);
        product.setId(null);
        int count = this.add(product);
        //根据促销类型设置价格：会员价格、阶梯价格、满减价格
        Long productId = product.getId();
        //会员价格
        relateAndInsertList(memberPriceMapper, productParam.getMemberPriceList(), productId);
        //阶梯价格
        relateAndInsertList(productLadderMapper, productParam.getProductLadderList(), productId);
        //满减价格
        relateAndInsertList(productFullReductionMapper, productParam.getProductFullReductionList(), productId);
        //处理sku的编码
        handleSkuStockCode(productParam.getSkuStockList(),productId);
        //添加sku库存信息
        relateAndInsertList(skuStockMapper, productParam.getSkuStockList(), productId);
        //添加商品参数,添加自定义商品规格
        relateAndInsertList(productAttributeValueMapper, productParam.getProductAttributeValueList(), productId);
        //关联专题
        relateAndInsertList(subjectProductRelationMapper, productParam.getSubjectProductRelationList(), productId);
        //关联优选
        relateAndInsertList(prefrenceAreaProductRelationMapper, productParam.getPrefrenceAreaProductRelationList(), productId);
        return count;
    }

    @Override
    public PmsProductResult getUpdateInfo(Long id) {
        return pmsProductResultMapper.getUpdateInfo(id);
    }

    @Override
    public int update(Long id, PmsProductParam productParam) {
        //更新商品信息
        PmsProduct product = PmsProductConvert.INSTANCE.pmsProductParamToEntity(productParam);
        product.setId(id);
        int count = this.update(product);
        //会员价格
        Example pmsMemberPriceExample = new Example(PmsMemberPrice.class);
        pmsMemberPriceExample.createCriteria().andEqualTo("productId",id);
        memberPriceMapper.deleteByExample(pmsMemberPriceExample);
        relateAndInsertList(memberPriceMapper, productParam.getMemberPriceList(), id);
        //阶梯价格
        Example ladderExample = new Example(PmsProductLadder.class);
        ladderExample.createCriteria().andEqualTo("productId",id);
        productLadderMapper.deleteByExample(ladderExample);
        relateAndInsertList(productLadderMapper, productParam.getProductLadderList(), id);
        //满减价格
        Example fullReductionExample = new Example(PmsProductFullReduction.class);
        fullReductionExample.createCriteria().andEqualTo("productId",id);
        productFullReductionMapper.deleteByExample(fullReductionExample);
        relateAndInsertList(productFullReductionMapper, productParam.getProductFullReductionList(), id);
        //修改sku库存信息
        handleUpdateSkuStockList(id, productParam);
        //修改商品参数,添加自定义商品规格
        Example productAttributeValueExample = new Example(PmsProductAttributeValue.class);
        productAttributeValueExample.createCriteria().andEqualTo("productId",id);
        productAttributeValueMapper.deleteByExample(productAttributeValueExample);
        relateAndInsertList(productAttributeValueMapper, productParam.getProductAttributeValueList(), id);
        //关联专题
        Example subjectProductRelationExample = new Example(CmsSubjectProductRelation.class);
        subjectProductRelationExample.createCriteria().andEqualTo("productId",id);
        subjectProductRelationMapper.deleteByExample(subjectProductRelationExample);
        relateAndInsertList(subjectProductRelationMapper, productParam.getSubjectProductRelationList(), id);
        //关联优选
        Example prefrenceAreaExample = new Example(CmsPrefrenceAreaProductRelation.class);
        prefrenceAreaExample.createCriteria().andEqualTo("productId",id);
        prefrenceAreaProductRelationMapper.deleteByExample(prefrenceAreaExample);
        relateAndInsertList(prefrenceAreaProductRelationMapper, productParam.getPrefrenceAreaProductRelationList(), id);
        return count;
    }

    @Override
    public List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(PmsProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteStatus",0);
        if (productQueryParam.getPublishStatus() != null) {
            criteria.andEqualTo("publishStatus",productQueryParam.getPublishStatus());
        }
        if (productQueryParam.getVerifyStatus() != null) {
            criteria.andEqualTo("verifyStatus",productQueryParam.getVerifyStatus());
        }
        if (!StrUtil.isEmpty(productQueryParam.getKeyword())) {
            criteria.andLike("name","%" + productQueryParam.getKeyword() + "%");
        }
        if (!StrUtil.isEmpty(productQueryParam.getProductSn())) {
            criteria.andEqualTo("productSn",productQueryParam.getProductSn());
        }
        if (productQueryParam.getBrandId() != null) {
            criteria.andEqualTo("brandId",productQueryParam.getBrandId());
        }
        if (productQueryParam.getProductCategoryId() != null) {
            criteria.andEqualTo("productCategoryId",productQueryParam.getProductCategoryId());
        }
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProduct> list(String keyword) {
        Example example = new Example(PmsProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteStatus",0);
        if(!StrUtil.isEmpty(keyword)){
            criteria.andLike("name","%" + keyword + "%");
            example.or().andEqualTo("deleteStatus",0).andLike("productSn","%" + keyword + "%");
        }
        return productMapper.selectByExample(example);
    }

    @Override
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        PmsProduct product = new PmsProduct();
        product.setVerifyStatus(verifyStatus);
        Example example = new Example(PmsProduct.class);
        example.createCriteria().andIn("id",ids);
        int count = productMapper.updateByExampleSelective(product, example);
        //修改完审核状态后插入审核记录
        List<PmsProductVertifyRecord> list = new ArrayList<>();
        for (Long id : ids) {
            PmsProductVertifyRecord record = new PmsProductVertifyRecord();
            record.setProductId(id);
            record.setCreateTime(new Date());
            record.setDetail(detail);
            record.setStatus(verifyStatus);
            record.setVertifyMan("test");
            list.add(record);
        }
        productVertifyRecordMapper.insertBatch(list);
        return count;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        PmsProduct record = new PmsProduct();
        record.setPublishStatus(publishStatus);
        Example example = new Example(PmsProduct.class);
        example.createCriteria().andIn("id",ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        PmsProduct record = new PmsProduct();
        record.setRecommandStatus(recommendStatus);
        Example example = new Example(PmsProduct.class);
        example.createCriteria().andIn("id",ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        PmsProduct record = new PmsProduct();
        record.setNewStatus(newStatus);
        Example example = new Example(PmsProduct.class);
        example.createCriteria().andIn("id",ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        PmsProduct record = new PmsProduct();
        record.setDeleteStatus(deleteStatus);
        Example example = new Example(PmsProduct.class);
        example.createCriteria().andIn("id",ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    private void relateAndInsertList(Object mapper, List<?> dataList, Long productId) {
        try {
            if (CollectionUtils.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item, -1L);
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item, productId);
            }
            Method insertList = mapper.getClass().getMethod("insertBatch", List.class);
            insertList.invoke(mapper, dataList);
        } catch (Exception e) {
            log.warn("创建产品出错:{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private void handleSkuStockCode(List<PmsSkuStock> skuStockList, Long productId) {
        if(CollectionUtils.isEmpty(skuStockList))return;
        for(int i=0;i<skuStockList.size();i++){
            PmsSkuStock skuStock = skuStockList.get(i);
            if(StrUtil.isEmpty(skuStock.getSkuCode())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String sb = sdf.format(new Date()) +        //日期
                        String.format("%04d", productId) +  //四位商品id
                        String.format("%03d", i + 1);       //三位索引id
                skuStock.setSkuCode(sb);
            }
        }
    }

    private void handleUpdateSkuStockList(Long id, PmsProductParam productParam) {
        //当前的sku信息
        List<PmsSkuStock> currSkuList = productParam.getSkuStockList();
        //当前没有sku直接删除
        if(CollUtil.isEmpty(currSkuList)){
            Example skuStockExample = new Example(PmsSkuStock.class);
            skuStockExample.createCriteria().andEqualTo("productId",id);
            skuStockMapper.deleteByExample(skuStockExample);
            return;
        }
        //获取初始sku信息
        Example skuStockExample = new Example(PmsSkuStock.class);
        skuStockExample.createCriteria().andEqualTo("productId",id);
        List<PmsSkuStock> oriStuList = skuStockMapper.selectByExample(skuStockExample);
        //获取新增sku信息
        List<PmsSkuStock> insertSkuList = currSkuList.stream().filter(item->item.getId()==null).collect(Collectors.toList());
        //获取需要更新的sku信息
        List<PmsSkuStock> updateSkuList = currSkuList.stream().filter(item->item.getId()!=null).collect(Collectors.toList());
        List<Long> updateSkuIds = updateSkuList.stream().map(PmsSkuStock::getId).collect(Collectors.toList());
        //获取需要删除的sku信息
        List<PmsSkuStock> removeSkuList = oriStuList.stream().filter(item-> !updateSkuIds.contains(item.getId())).collect(Collectors.toList());
        handleSkuStockCode(insertSkuList,id);
        handleSkuStockCode(updateSkuList,id);
        //新增sku
        if(CollUtil.isNotEmpty(insertSkuList)){
            relateAndInsertList(skuStockMapper, insertSkuList, id);
        }
        //删除sku
        if(CollUtil.isNotEmpty(removeSkuList)){
            List<Long> removeSkuIds = removeSkuList.stream().map(PmsSkuStock::getId).collect(Collectors.toList());
            Example removeExample = new Example(PmsSkuStock.class);
            removeExample.createCriteria().andIn("id",removeSkuIds);
            skuStockMapper.deleteByExample(removeExample);
        }
        //修改sku
        if(CollUtil.isNotEmpty(updateSkuList)){
            for (PmsSkuStock pmsSkuStock : updateSkuList) {
                skuStockMapper.updateByPrimaryKeySelective(pmsSkuStock);
            }
        }

    }
}

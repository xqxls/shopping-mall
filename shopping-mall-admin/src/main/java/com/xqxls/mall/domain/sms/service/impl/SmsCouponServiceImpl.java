package com.xqxls.mall.domain.sms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.sms.dto.SmsCouponParam;
import com.xqxls.mall.domain.sms.entity.SmsCoupon;
import com.xqxls.mall.domain.sms.entity.SmsCouponProductCategoryRelation;
import com.xqxls.mall.domain.sms.entity.SmsCouponProductRelation;
import com.xqxls.mall.domain.sms.enums.SmsCouponTypeEnum;
import com.xqxls.mall.domain.sms.service.SmsCouponService;
import com.xqxls.mall.mapper.SmsCouponMapper;
import com.xqxls.mall.mapper.SmsCouponParamMapper;
import com.xqxls.mall.mapper.SmsCouponProductCategoryRelationMapper;
import com.xqxls.mall.mapper.SmsCouponProductRelationMapper;
import com.xqxls.mall.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 优惠券表 服务实现类
 *
 * @author xqxls
 * @date 2023-06-16 3:19 下午
 */
@Service
public class SmsCouponServiceImpl extends ServiceImpl<SmsCouponMapper, SmsCoupon> implements SmsCouponService {

    @Autowired
    private SmsCouponMapper couponMapper;

    @Autowired
    private SmsCouponProductRelationMapper productRelationMapper;

    @Autowired
    private SmsCouponProductCategoryRelationMapper productCategoryRelationMapper;

    @Autowired
    private SmsCouponParamMapper smsCouponParamMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(SmsCouponParam couponParam) {
        couponParam.setCount(couponParam.getPublishCount());
        couponParam.setUseCount(0);
        couponParam.setReceiveCount(0);
        //插入优惠券表
        int count = couponMapper.insert(couponParam);
        //插入优惠券和商品关系表
        if(SmsCouponTypeEnum.SHOP_COUPON.getCode().equals(couponParam.getUseType())){
            for(SmsCouponProductRelation productRelation:couponParam.getProductRelationList()){
                productRelation.setCouponId(couponParam.getId());
            }
            productRelationMapper.insertBatch(couponParam.getProductRelationList());
        }
        //插入优惠券和商品分类关系表
        if(SmsCouponTypeEnum.MEMBER_COUPON.getCode().equals(couponParam.getUseType())){
            for (SmsCouponProductCategoryRelation couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            productCategoryRelationMapper.insertBatch(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long id) {
        //删除优惠券
        int count = couponMapper.deleteByPrimaryKey(id);
        //删除商品关联
        deleteProductRelation(id);
        //删除商品分类关联
        deleteProductCategoryRelation(id);
        return count;
    }

    private void deleteProductCategoryRelation(Long id) {
        Example example = new Example(SmsCouponProductCategoryRelation.class);
        example.createCriteria().andEqualTo("couponId",id);
        productCategoryRelationMapper.deleteByExample(example);
    }

    private void deleteProductRelation(Long id) {
        Example example = new Example(SmsCouponProductRelation.class);
        example.createCriteria().andEqualTo("couponId",id);
        productRelationMapper.deleteByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(Long id, SmsCouponParam couponParam) {
        couponParam.setId(id);
        int count =couponMapper.updateByPrimaryKey(couponParam);
        //删除后插入优惠券和商品关系表
        if(SmsCouponTypeEnum.SHOP_COUPON.getCode().equals(couponParam.getUseType())){
            for(SmsCouponProductRelation productRelation:couponParam.getProductRelationList()){
                productRelation.setCouponId(couponParam.getId());
            }
            deleteProductRelation(id);
            productRelationMapper.insertBatch(couponParam.getProductRelationList());
        }
        //删除后插入优惠券和商品分类关系表
        if(SmsCouponTypeEnum.MEMBER_COUPON.getCode().equals(couponParam.getUseType())){
            for (SmsCouponProductCategoryRelation couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            deleteProductCategoryRelation(id);
            productCategoryRelationMapper.insertBatch(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    public List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
        Example example = new Example(SmsCoupon.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StrUtil.isEmpty(name)){
            criteria.andLike("name","%"+name+"%");
        }
        if(type!=null){
            criteria.andEqualTo("type",type);
        }
        PageHelper.startPage(pageNum,pageSize);
        return couponMapper.selectByExample(example);
    }

    @Override
    public SmsCouponParam getItem(Long id) {
        return smsCouponParamMapper.getItem(id);
    }
}

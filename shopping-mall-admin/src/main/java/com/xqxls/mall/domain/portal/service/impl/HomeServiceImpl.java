package com.xqxls.mall.domain.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.pms.entity.PmsProductCategory;
import com.xqxls.mall.domain.portal.dto.FlashPromotionProduct;
import com.xqxls.mall.domain.portal.dto.HomeContentResult;
import com.xqxls.mall.domain.portal.dto.HomeFlashPromotion;
import com.xqxls.mall.domain.portal.entity.CmsSubject;
import com.xqxls.mall.domain.portal.service.HomeService;
import com.xqxls.mall.domain.portal.util.DateUtil;
import com.xqxls.mall.domain.sms.entity.SmsFlashPromotion;
import com.xqxls.mall.domain.sms.entity.SmsFlashPromotionSession;
import com.xqxls.mall.domain.sms.entity.SmsHomeAdvertise;
import com.xqxls.mall.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 10:00
 * @Description 首页内容管理Service实现类
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;
    @Autowired
    private HomeMapper homeMapper;
    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;
    @Autowired
    private SmsFlashPromotionSessionMapper promotionSessionMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取推荐品牌
        result.setBrandList(homeMapper.getRecommendBrandList(0,6));
        //获取秒杀信息
        result.setHomeFlashPromotion(getHomeFlashPromotion());
        //获取新品推荐
        result.setNewProductList(homeMapper.getNewProductList(0,4));
        //获取人气推荐
        result.setHotProductList(homeMapper.getHotProductList(0,4));
        //获取推荐专题
        result.setSubjectList(homeMapper.getRecommendSubjectList(0,4));
        return result;
    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        // 暂时默认推荐所有商品
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(PmsProduct.class);
        example.createCriteria()
                .andEqualTo("deleteStatus",0)
                .andEqualTo("publishStatus",1);
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategory> getProductCateList(Long parentId) {
        Example example = new Example(PmsProductCategory.class);
        example.createCriteria()
                .andEqualTo("showStatus",1)
                .andEqualTo("parentId",parentId);
        example.orderBy("sort").desc();
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(CmsSubject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("showStatus",1);
        if(cateId!=null){
            criteria.andEqualTo("categoryId",cateId);
        }
        return subjectMapper.selectByExample(example);
    }

    @Override
    public List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize) {
        int offset = pageSize * (pageNum - 1);
        return homeMapper.getHotProductList(offset, pageSize);
    }

    @Override
    public List<PmsProduct> newProductList(Integer pageNum, Integer pageSize) {
        int offset = pageSize * (pageNum - 1);
        return homeMapper.getNewProductList(offset, pageSize);
    }

    private HomeFlashPromotion getHomeFlashPromotion() {
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        Date now = new Date();
        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            //获取当前秒杀场次
            SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                //获取下一个秒杀场次
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if(nextSession!=null){
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //获取秒杀商品
                List<FlashPromotionProduct> flashProductList = homeMapper.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;
    }

    private SmsFlashPromotionSession getNextFlashPromotionSession(Date date) {
        //获取下一个场次信息
        Example sessionExample = new Example(SmsFlashPromotionSession.class);
        sessionExample.createCriteria()
                .andGreaterThan("startTime",date);
        sessionExample.orderBy("startTime").asc();
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        Example example = new Example(SmsHomeAdvertise.class);
        example.createCriteria().andEqualTo("type",1).andEqualTo("status",1);
        example.orderBy("sort").desc();
        return advertiseMapper.selectByExample(example);
    }


    private SmsFlashPromotion getFlashPromotion(Date date) {
        //根据时间获取秒杀活动
        Date currDate = DateUtil.getDate(date);
        Example example = new Example(SmsFlashPromotion.class);
        example.createCriteria()
                .andEqualTo("status",1)
                .andLessThanOrEqualTo("startDate",currDate)
                .andGreaterThanOrEqualTo("endDate",currDate);
        List<SmsFlashPromotion> flashPromotionList = flashPromotionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(flashPromotionList)) {
            return flashPromotionList.get(0);
        }
        return null;
    }


    private SmsFlashPromotionSession getFlashPromotionSession(Date date) {
        //根据时间获取秒杀场次
        Date currTime = DateUtil.getTime(date);
        Example sessionExample = new Example(SmsFlashPromotionSession.class);
        sessionExample.createCriteria()
                .andLessThanOrEqualTo("startTime",currTime)
                .andGreaterThanOrEqualTo("endTime",currTime);
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }
}

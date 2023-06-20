package com.xqxls.mall.domain.portal.dto;

import com.xqxls.mall.domain.pms.entity.PmsBrand;
import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.portal.entity.CmsSubject;
import com.xqxls.mall.domain.sms.entity.SmsHomeAdvertise;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 10:01
 * @Description 首页内容返回信息封装
 */
@Getter
@Setter
public class HomeContentResult {

    @ApiModelProperty("轮播广告")
    private List<SmsHomeAdvertise> advertiseList;

    @ApiModelProperty("推荐品牌")
    private List<PmsBrand> brandList;

    @ApiModelProperty("当前秒杀场次")
    private HomeFlashPromotion homeFlashPromotion;

    @ApiModelProperty("新品推荐")
    private List<PmsProduct> newProductList;

    @ApiModelProperty("人气推荐")
    private List<PmsProduct> hotProductList;

    @ApiModelProperty("推荐专题")
    private List<CmsSubject> subjectList;
}

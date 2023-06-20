package com.xqxls.mall.domain.portal.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 10:02
 * @Description 首页秒杀场次信息封装
 */
@Getter
@Setter
public class HomeFlashPromotion {

    @ApiModelProperty("本场开始时间")
    private Date startTime;

    @ApiModelProperty("本场结束时间")
    private Date endTime;

    @ApiModelProperty("下场开始时间")
    private Date nextStartTime;

    @ApiModelProperty("下场结束时间")
    private Date nextEndTime;

    @ApiModelProperty("属于该秒杀活动的商品")
    private List<FlashPromotionProduct> productList;
}

package com.xqxls.mall.domain.sms.dto;

import com.xqxls.mall.domain.sms.entity.SmsFlashPromotionSession;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xqxls
 * @create 2023-06-16 16:38
 * @Description 包含商品数量的场次信息
 */
public class SmsFlashPromotionSessionDetail extends SmsFlashPromotionSession {
    @Setter
    @Getter
    @ApiModelProperty("商品数量")
    private Long productCount;
}

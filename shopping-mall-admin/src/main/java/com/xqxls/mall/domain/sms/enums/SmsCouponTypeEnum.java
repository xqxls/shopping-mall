package com.xqxls.mall.domain.sms.enums;

/**
 * @author xqxls
 * @create 2023-06-16 16:52
 * @Description 优惠券类型
 */
public enum SmsCouponTypeEnum {

    /** 全场赠券 **/
    FULL_COUPON(0, "全场赠券"),

    /** 会员赠券 **/
    MEMBER_COUPON(1, "会员赠券"),

    /** 购物赠券 **/
    SHOP_COUPON(2, "购物赠券"),

    /** 注册赠券 **/
    REGISTER_COUPON(3, "注册赠券");

    private Integer code;

    private String desc;

    SmsCouponTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

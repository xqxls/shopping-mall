package com.xqxls.mall.domain.oms.enums;

/**
 * @author xqxls
 * @create 2023-06-16 14:28
 * @Description
 */
public enum OrderStatusEnum {

    /** 待付款 **/
    WAIT_PAY(0, "待付款"),

    /** 待发货 **/
    WAIT_DELIVERY(1, "待发货"),

    /** 已发货 **/
    HAVE_DELIVERY(2, "已发货"),

    /** 已完成 **/
    HAVE_COMPLETE(3, "已完成"),

    /** 已关闭 **/
    HAVE_CLOSE(4, "已关闭"),

    /** 无效订单 **/
    NOT_VALID(5, "无效订单");

    private Integer code;

    private String desc;

    OrderStatusEnum(Integer code, String desc) {
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

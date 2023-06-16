package com.xqxls.mall.domain.oms.enums;

/**
 * @author xqxls
 * @create 2023-06-16 10:28
 * @Description 申请状态
 */
public enum ReturnApplyStatusEnum {

    /** 待处理 **/
    WAIT_HANDLE(0, "待处理"),

    /** 退货中 **/
    RETURN_GOODS(1, "退货中"),

    /** 已完成 **/
    HAVE_COMPLETE(2, "已完成"),

    /** 已拒绝 **/
    HAVE_REFUSE(3, "已拒绝");

    private Integer code;

    private String desc;

    ReturnApplyStatusEnum(Integer code, String desc) {
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

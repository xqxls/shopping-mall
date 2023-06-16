package com.xqxls.mall.domain.oms.enums;

/**
 * @author xqxls
 * @create 2023-06-16 13:36
 * @Description
 */
public enum EnableEnum {

    /** 启用 **/
    YES(1),

    /** 不启用 **/
    NO(0);

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    EnableEnum(Integer code) {
        this.code = code;
    }
}

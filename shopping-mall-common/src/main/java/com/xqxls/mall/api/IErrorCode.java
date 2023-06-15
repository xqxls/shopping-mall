package com.xqxls.mall.api;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description API返回码接口
 */
public interface IErrorCode {
    /**
     * 返回码
     * @return 返回码
     */
    long getCode();

    /**
     * 返回信息
     * @return 返回信息
     */
    String getMessage();
}

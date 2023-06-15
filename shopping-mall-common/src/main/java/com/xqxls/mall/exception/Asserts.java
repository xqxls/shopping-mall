package com.xqxls.mall.exception;

import com.xqxls.mall.api.IErrorCode;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description 断言处理类，用于抛出各种API异常
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}

package com.xqxls.mall.annotation;

import java.lang.annotation.*;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description 自定义缓存异常注解，有该注解的缓存方法会抛出异常
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}

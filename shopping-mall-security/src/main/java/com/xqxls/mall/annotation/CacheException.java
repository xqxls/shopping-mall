package com.xqxls.mall.annotation;

import java.lang.annotation.*;

/**
 * 自定义缓存异常注解，有该注解的缓存方法会抛出异常
 * Created by xqxls on 2020/3/17.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}

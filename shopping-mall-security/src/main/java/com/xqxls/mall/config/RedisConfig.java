package com.xqxls.mall.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description Redis配置类
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}

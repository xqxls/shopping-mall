package com.xqxls.mall.config;

import com.xqxls.mall.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置类
 * Created by xqxls on 2020/3/2.
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}

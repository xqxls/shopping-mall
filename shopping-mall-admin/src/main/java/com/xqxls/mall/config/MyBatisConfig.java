package com.xqxls.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by xqxls on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.xqxls.mall.mapper","com.xqxls.mall.dao"})
public class MyBatisConfig {
}

package com.xqxls.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * MyBatis相关配置
 * Created by xqxls on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.xqxls.mall.mapper"})
public class MyBatisConfig {

}

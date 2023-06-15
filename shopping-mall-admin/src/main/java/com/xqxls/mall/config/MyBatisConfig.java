package com.xqxls.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description MyBatis相关配置
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.xqxls.mall.mapper"})
public class MyBatisConfig {

}

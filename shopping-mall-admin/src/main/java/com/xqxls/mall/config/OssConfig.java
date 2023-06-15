package com.xqxls.mall.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description OSS对象存储相关配置
 */
@Configuration
public class OssConfig {

    @Value("${aliyun.oss.endpoint}")
    private String aLiYunOssEndPoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String aLiYunOssAccessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String aLiYunOssAccessKeySecret;

    @Bean
    public OSSClient ossClient(){
        return new OSSClient(aLiYunOssEndPoint,aLiYunOssAccessKeyId,aLiYunOssAccessKeySecret);
    }
}

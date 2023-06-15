package com.xqxls.mall.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description 动态权限相关业务接口
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     * @return 资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}

package com.xqxls.mall.mapper;

import com.xqxls.mall.domain.pms.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;

/**
 * @author 胡卓
 * @create 2023-05-10 14:39
 * @Description
 */
public interface PmsProductResultMapper {

    /**
     * 根据商品ID获取商品更新信息
     * @param id 商品ID
     * @return 商品更新信息
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}

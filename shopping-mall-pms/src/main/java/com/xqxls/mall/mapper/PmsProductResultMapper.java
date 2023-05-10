package com.xqxls.mall.mapper;

import com.xqxls.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;

/**
 * @author 胡卓
 * @create 2023-05-10 14:39
 * @Description
 */
public interface PmsProductResultMapper {


    /**
     * 获取商品编辑信息
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}

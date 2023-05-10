package com.xqxls.mall.mapper;

import com.xqxls.mall.base.TkBaseMapper;
import com.xqxls.mall.dto.PmsProductResult;
import com.xqxls.mall.entity.PmsBrand;
import com.xqxls.mall.entity.PmsProduct;
import org.apache.ibatis.annotations.Param;

/**
 * 商品信息 Mapper 接口
 * 
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
public interface PmsProductMapper extends TkBaseMapper<PmsProduct> {

    void updateByBrand(@Param("brandName") String brandName,@Param("brandId") Long brandId);

}
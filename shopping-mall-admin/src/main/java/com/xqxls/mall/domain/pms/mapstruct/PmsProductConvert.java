package com.xqxls.mall.domain.pms.mapstruct;

import com.xqxls.mall.domain.pms.dto.PmsProductParam;
import com.xqxls.mall.domain.pms.entity.PmsProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 商品转换器
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Mapper
public interface PmsProductConvert {

    PmsProductConvert INSTANCE = Mappers.getMapper(PmsProductConvert.class);

    /**
     * 商品参数转换为商品实体
     * @param pmsProductParam 商品参数
     * @return 商品实体
     */
    PmsProduct pmsProductParamToEntity(PmsProductParam pmsProductParam);
}

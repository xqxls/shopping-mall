package com.xqxls.mall.mapstruct;

import com.xqxls.mall.dto.PmsProductParam;
import com.xqxls.mall.entity.PmsProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PmsProductConvert {

    PmsProductConvert INSTANCE = Mappers.getMapper(PmsProductConvert.class);

    PmsProduct pmsProductParamToEntity(PmsProductParam pmsProductParam);
}

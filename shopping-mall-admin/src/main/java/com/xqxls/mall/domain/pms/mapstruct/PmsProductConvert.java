package com.xqxls.mall.domain.pms.mapstruct;

import com.xqxls.mall.domain.pms.dto.PmsProductParam;
import com.xqxls.mall.domain.pms.entity.PmsProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PmsProductConvert {

    PmsProductConvert INSTANCE = Mappers.getMapper(PmsProductConvert.class);

    PmsProduct pmsProductParamToEntity(PmsProductParam pmsProductParam);
}

package com.xqxls.mall.domain.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.xqxls.mall.api.CommonPage;
import com.xqxls.mall.domain.pms.entity.PmsBrand;
import com.xqxls.mall.domain.pms.entity.PmsProduct;
import com.xqxls.mall.domain.portal.service.PmsPortalBrandService;
import com.xqxls.mall.mapper.HomeMapper;
import com.xqxls.mall.mapper.PmsBrandMapper;
import com.xqxls.mall.mapper.PmsProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 14:44
 * @Description 前台品牌管理Service实现类
 */
@Service
public class PmsPortalBrandServiceImpl implements PmsPortalBrandService {

    @Autowired
    private HomeMapper homeMapper;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public List<PmsBrand> recommendList(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return homeMapper.getRecommendBrandList(offset, pageSize);
    }

    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(PmsProduct.class);
        example.createCriteria().andEqualTo("deleteStatus",0)
                .andEqualTo("publishStatus",1)
                .andEqualTo("brandId",brandId);
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}

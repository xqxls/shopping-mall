package com.xqxls.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xqxls.mall.dto.PmsBrandParam;
import com.xqxls.mall.mapper.PmsProductMapper;
import com.xqxls.mall.service.PmsBrandService;
import com.xqxls.mall.entity.PmsBrand;
import com.xqxls.mall.mapper.PmsBrandMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 品牌表 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Override
    public int createBrand(PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StrUtil.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        return this.add(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        pmsBrand.setId(id);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StrUtil.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        //更新品牌时要更新商品中的品牌名称
        pmsProductMapper.updateByBrand(pmsBrand.getName(),pmsBrand.getId());
        return this.update(pmsBrand);
    }

    @Override
    public List<PmsBrand> listBrand(String keyword, Integer showStatus, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(PmsBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(keyword)) {
            criteria.andLike("name","%" + keyword + "%");
        }
        if(showStatus!=null){
            criteria.andEqualTo("showStatus",showStatus);
        }
        example.orderBy("sort").desc();
        return pmsBrandMapper.selectByExample(example);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setShowStatus(showStatus);
        Example example = new Example(PmsBrand.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        return pmsBrandMapper.updateByExampleSelective(pmsBrand,example);
    }

    @Override
    public int updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setFactoryStatus(factoryStatus);
        Example example = new Example(PmsBrand.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        return pmsBrandMapper.updateByExampleSelective(pmsBrand,example);
    }
}

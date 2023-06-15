package com.xqxls.mall.domain.ums.controller;

import com.xqxls.mall.api.CommonResult;
import com.xqxls.mall.domain.ums.entity.UmsResourceCategory;
import com.xqxls.mall.domain.ums.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源分类表 前端控制器
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Api(tags = "资源分类表前端控制器")
@RestController
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    
    @Autowired
    private UmsResourceCategoryService umsResourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<UmsResourceCategory>> listAll() {
        List<UmsResourceCategory> resourceList = umsResourceCategoryService.findAll();
        return CommonResult.success(resourceList);
    }

    @ApiOperation("添加后台资源分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<Void> create(@RequestBody UmsResourceCategory umsResourceCategory) {
        int count = umsResourceCategoryService.create(umsResourceCategory);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("修改后台资源分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public CommonResult<Void> update(@PathVariable Long id,
                                     @RequestBody UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setId(id);
        int count = umsResourceCategoryService.update(umsResourceCategory);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public CommonResult<Void> delete(@PathVariable Long id) {
        int count = umsResourceCategoryService.deleteById(id);
        return CommonResult.getCountResult(count);
    }
}

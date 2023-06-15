package com.xqxls.mall.domain.ums.controller;

import com.xqxls.mall.api.CommonPage;
import com.xqxls.mall.api.CommonResult;
import com.xqxls.mall.component.DynamicSecurityMetadataSource;
import com.xqxls.mall.domain.ums.entity.UmsResource;
import com.xqxls.mall.domain.ums.service.UmsResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源表 前端控制器
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Api(tags = "后台资源表前端控制器")
@RestController
@RequestMapping("/resource")
public class UmsResourceController {

    @Autowired
    private UmsResourceService umsResourceService;

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @ApiOperation("添加后台资源")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<Void> create(@RequestBody UmsResource umsResource) {
        int count = umsResourceService.create(umsResource);
        dynamicSecurityMetadataSource.clearDataSource();
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("修改后台资源")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public CommonResult<Void> update(@PathVariable Long id,
                                     @RequestBody UmsResource umsResource) {
        int count = umsResourceService.update(id, umsResource);
        dynamicSecurityMetadataSource.clearDataSource();
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("根据ID获取资源详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<UmsResource> getItem(@PathVariable Long id) {
        UmsResource umsResource = umsResourceService.findById(id);
        return CommonResult.success(umsResource);
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public CommonResult<Void> delete(@PathVariable Long id) {
        int count = umsResourceService.delete(id);
        dynamicSecurityMetadataSource.clearDataSource();
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<UmsResource>> list(@RequestParam(required = false) Long categoryId,
                                                      @RequestParam(required = false) String nameKeyword,
                                                      @RequestParam(required = false) String urlKeyword,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsResource> resourceList = umsResourceService.list(categoryId,nameKeyword, urlKeyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(resourceList));
    }

    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<UmsResource>> listAll() {
        List<UmsResource> resourceList = umsResourceService.findAll();
        return CommonResult.success(resourceList);
    }
}

package com.xqxls.mall.domain.ums.controller;

import com.xqxls.mall.api.CommonPage;
import com.xqxls.mall.api.CommonResult;
import com.xqxls.mall.domain.ums.entity.UmsMenu;
import com.xqxls.mall.domain.ums.entity.UmsResource;
import com.xqxls.mall.domain.ums.entity.UmsRole;
import com.xqxls.mall.domain.ums.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户角色表 前端控制器
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Api(tags = "后台用户角色表前端控制器")
@RestController
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    private UmsRoleService umsRoleService;

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<Void> create(@RequestBody UmsRole umsRole) {
        int count = umsRoleService.create(umsRole);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public CommonResult<Void> update(@PathVariable Long id, @RequestBody UmsRole umsRole) {
        umsRole.setId(id);
        int count = umsRoleService.update(umsRole);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public CommonResult<Void> delete(@RequestParam("ids") List<Long> ids) {
        umsRoleService.deleteByIds(ids);
        return CommonResult.success(null);
    }


    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<UmsRole>> listAll() {
        List<UmsRole> roleList = umsRoleService.findAll();
        return CommonResult.success(roleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsRole> roleList = umsRoleService.list(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("修改角色状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.PUT)
    public CommonResult<Void> updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsRole umsRole = new UmsRole();
        umsRole.setId(id);
        umsRole.setStatus(status);
        int count = umsRoleService.update(umsRole);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("获取角色相关菜单")
    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.GET)
    public CommonResult<List<UmsMenu>> listMenu(@PathVariable Long roleId) {
        List<UmsMenu> menuList = umsRoleService.listMenu(roleId);
        return CommonResult.success(menuList);
    }

    @ApiOperation("获取角色相关资源")
    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.GET)
    public CommonResult<List<UmsResource>> listResource(@PathVariable Long roleId) {
        List<UmsResource> resourceList = umsRoleService.listResource(roleId);
        return CommonResult.success(resourceList);
    }

    @ApiOperation("给角色分配菜单")
    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
    public CommonResult<Integer> allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = umsRoleService.allocMenu(roleId, menuIds);
        return CommonResult.success(count);
    }

    @ApiOperation("给角色分配资源")
    @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
    public CommonResult<Integer> allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int count = umsRoleService.allocResource(roleId, resourceIds);
        return CommonResult.success(count);
    }
}

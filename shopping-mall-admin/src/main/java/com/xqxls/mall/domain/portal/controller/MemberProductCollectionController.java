package com.xqxls.mall.domain.portal.controller;

import com.xqxls.mall.api.CommonPage;
import com.xqxls.mall.api.CommonResult;
import com.xqxls.mall.domain.portal.dto.MemberProductCollection;
import com.xqxls.mall.domain.portal.service.MemberCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author xqxls
 * @create 2023-06-20 15:24
 * @Description 会员商品收藏管理Controller
 */
@Controller
@Api(tags = "MemberCollectionController")
@Tag(name = "MemberCollectionController",description = "会员收藏管理")
@RequestMapping("/member/productCollection")
public class MemberProductCollectionController {

    @Autowired
    private MemberCollectionService memberCollectionService;

    @ApiOperation("添加商品收藏")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Void> add(@RequestBody MemberProductCollection productCollection) {
        int count = memberCollectionService.add(productCollection);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("删除商品收藏")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Void> delete(Long productId) {
        int count = memberCollectionService.delete(productId);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("显示当前用户商品收藏列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<MemberProductCollection>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<MemberProductCollection> page = memberCollectionService.list(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("显示商品收藏详情")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<MemberProductCollection> detail(@RequestParam Long productId) {
        MemberProductCollection memberProductCollection = memberCollectionService.detail(productId);
        return CommonResult.success(memberProductCollection);
    }

    @ApiOperation("清空当前用户商品收藏列表")
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Void> clear() {
        memberCollectionService.clear();
        return CommonResult.success(null);
    }
}

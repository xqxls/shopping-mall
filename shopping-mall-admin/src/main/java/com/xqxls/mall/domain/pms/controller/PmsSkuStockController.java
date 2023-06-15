package com.xqxls.mall.domain.pms.controller;

import com.xqxls.mall.api.CommonResult;
import com.xqxls.mall.domain.pms.entity.PmsSkuStock;
import com.xqxls.mall.domain.pms.service.PmsSkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * sku的库存 前端控制器
 *
 * @author xqxls
 * @date 2023-05-09 5:39 下午
 */
@Api(tags = "sku的库存前端控制器")
@RestController
@RequestMapping("/sku")
public class PmsSkuStockController {

    @Autowired
    private PmsSkuStockService skuStockService;

    @ApiOperation("根据商品ID及sku编码模糊搜索sku库存")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsSkuStock>> getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword) {
        List<PmsSkuStock> skuStockList = skuStockService.getList(pid, keyword);
        return CommonResult.success(skuStockList);
    }

    @ApiOperation("批量更新sku库存信息")
    @RequestMapping(value ="/update/{pid}",method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<Void> update(@PathVariable Long pid,@RequestBody List<PmsSkuStock> skuStockList){
        int count = skuStockService.update(pid,skuStockList);
        return CommonResult.getCountResult(count);
    }
}

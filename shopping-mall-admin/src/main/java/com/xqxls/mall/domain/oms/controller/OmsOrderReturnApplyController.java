package com.xqxls.mall.domain.oms.controller;

import com.xqxls.mall.api.CommonPage;
import com.xqxls.mall.api.CommonResult;
import com.xqxls.mall.domain.oms.dto.OmsOrderReturnApplyResult;
import com.xqxls.mall.domain.oms.dto.OmsReturnApplyQueryParam;
import com.xqxls.mall.domain.oms.dto.OmsUpdateStatusParam;
import com.xqxls.mall.domain.oms.entity.OmsOrderReturnApply;
import com.xqxls.mall.domain.oms.service.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单退货申请管理 前端控制器
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Api(tags = "订单退货申请前端控制器")
@RestController
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {

    @Autowired
    private OmsOrderReturnApplyService returnApplyService;

    @ApiOperation("分页查询退货申请")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderReturnApply>> list(OmsReturnApplyQueryParam queryParam,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrderReturnApply> returnApplyList = returnApplyService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(returnApplyList));
    }

    @ApiOperation("批量删除退货申请")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Void> delete(@RequestParam("ids") List<Long> ids) {
        int count = returnApplyService.delete(ids);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("获取退货申请详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderReturnApplyResult> getItem(@PathVariable Long id) {
        OmsOrderReturnApplyResult result = returnApplyService.getItem(id);
        return CommonResult.success(result);
    }

    @ApiOperation("修改退货申请状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<Void> updateStatus(@PathVariable Long id, @RequestBody OmsUpdateStatusParam statusParam) {
        int count = returnApplyService.updateStatus(id, statusParam);
        return CommonResult.getCountResult(count);
    }

}

package com.xqxls.mall.domain.oms.controller;

import com.xqxls.mall.api.CommonPage;
import com.xqxls.mall.api.CommonResult;
import com.xqxls.mall.domain.oms.dto.*;
import com.xqxls.mall.domain.oms.entity.OmsOrder;
import com.xqxls.mall.domain.oms.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理 前端控制器
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Api(tags = "订单表前端控制器")
@RestController
@RequestMapping("/order")
public class OmsOrderController {

    @Autowired
    private OmsOrderService orderService;

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam queryParam,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = orderService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<Void> delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList) {
        int count = orderService.delivery(deliveryParamList);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<Void> close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        int count = orderService.close(ids, note);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Void> delete(@RequestParam("ids") List<Long> ids) {
        int count = orderService.delete(ids);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("获取订单详情：订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> detail(@PathVariable Long id) {
        OmsOrderDetail orderDetailResult = orderService.detail(id);
        return CommonResult.success(orderDetailResult);
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<Void> updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam) {
        int count = orderService.updateReceiverInfo(receiverInfoParam);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<Void> updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam) {
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        return CommonResult.getCountResult(count);
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<Void> updateNote(@RequestParam("id") Long id,
                                   @RequestParam("note") String note,
                                   @RequestParam("status") Integer status) {
        int count = orderService.updateNote(id, note, status);
        return CommonResult.getCountResult(count);
    }
}

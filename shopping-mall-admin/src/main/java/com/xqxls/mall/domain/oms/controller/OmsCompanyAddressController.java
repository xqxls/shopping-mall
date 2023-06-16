package com.xqxls.mall.domain.oms.controller;

import com.xqxls.mall.api.CommonResult;
import com.xqxls.mall.domain.oms.entity.OmsCompanyAddress;
import com.xqxls.mall.domain.oms.service.OmsCompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 收货地址管理 前端控制器
 *
 * @author xqxls
 * @date 2023-06-16 10:05 上午
 */
@Api(tags = "公司收发货地址表前端控制器")
@RestController
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController {

    @Autowired
    private OmsCompanyAddressService companyAddressService;

    @ApiOperation("获取所有收货地址")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsCompanyAddress>> list() {
        List<OmsCompanyAddress> companyAddressList = companyAddressService.list();
        return CommonResult.success(companyAddressList);
    }

}

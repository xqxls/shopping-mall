package com.xqxls.mall.controller;

import com.xqxls.mall.common.api.CommonResult;
import com.xqxls.mall.model.UmsMemberLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2023/9/26 21:29
 */
@Controller
@Api(tags = "TestController")
@Tag(name = "TestController", description = "测试")
@RequestMapping("/api")
public class TestController {

    @ApiOperation("轮询调用")
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> polling() {
        return CommonResult.success("hello");
    }

    @ApiOperation("测试接口")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> test() {
        return CommonResult.success("test");
    }
}

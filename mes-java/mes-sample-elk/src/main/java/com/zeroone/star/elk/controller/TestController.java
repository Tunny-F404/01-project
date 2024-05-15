package com.zeroone.star.elk.controller;

import com.zeroone.star.project.dto.sample.SampleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述：示例控制器测试发送请求
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@RestController
@RequestMapping("elk")
@Api(tags = "测试接口")
public class TestController {
    /**
     * 测试请求
     * @param dto 请求消息内容
     * @return 测试返回数据
     */
    @ApiOperation(value = "测试请求")
    @GetMapping(value = "get")
    public String sendMail(SampleDTO dto) {
        return "hello elk";
    }
}
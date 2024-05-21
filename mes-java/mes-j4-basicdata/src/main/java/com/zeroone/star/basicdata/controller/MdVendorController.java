package com.zeroone.star.basicdata.controller;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 供应商相关操作 前端控制器
 * </p>
 *
 * @author 本鼠
 * @since 2024-05-21
 */

@RestController
@Api(tags = "供应商相关操作")
@RequestMapping("/basicData/vendor")
@Validated
public class MdVendorController {

}

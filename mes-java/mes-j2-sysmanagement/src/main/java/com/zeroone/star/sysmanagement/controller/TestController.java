package com.zeroone.star.sysmanagement.controller;

import com.zeroone.star.project.j2.sysmanagement.TestApis;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description: 测试控制器
 */
@RestController
@RequestMapping("test")
@Api(tags = "测试控制器")
public class TestController  implements TestApis {


}

package com.zeroone.star.sysmanagent.controller;

import com.zeroone.star.project.j2.orgstructure.DepartmentApis;
import com.zeroone.star.project.j2.orgstructure.dto.DepartmentDTO;
import com.zeroone.star.project.j2.sysmanagent.TestApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description: 测试控制器
 */
@RestController
@RequestMapping("test")
@Api(tags = "测试控制器")
public class DepartmentController  implements TestApis {


}

package com.zeroone.star.sysmanagement.controller;

import com.zeroone.star.project.j2.sysmanagement.SysmanagementApis;
import com.zeroone.star.project.j2.sysmanagement.dto.SysmanagementDTO;
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
@RequestMapping("sys")
@Api(tags = "测试控制器")
public class SysmanagementController implements SysmanagementApis {


    @PostMapping("add-resource")
    @ApiOperation("新增资源")
    @Override
    public JsonVO<SysmanagementDTO> addResource(@RequestBody SysmanagementDTO sysmanagentDTO) {
        return JsonVO.success(sysmanagentDTO);
    }

    @PostMapping("remove-resource")
    @ApiOperation("删除资源")
    @Override
    public JsonVO<Integer> removeResource(String id) {
        return JsonVO.success(1);
    }

    @PostMapping("modify-resource")
    @ApiOperation("修改资源")
    @Override
    public JsonVO<Integer> modifyResource(SysmanagementDTO resourceDTO) {
        return null;
    }
}

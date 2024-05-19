package com.zeroone.star.sysmanagement.controller;


import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanagement.service.ISysOperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 操作日志记录 前端控制器
 * </p>
 *
 * @author lenyan
 * @since 2024-05-19
 */
@RestController
@RequestMapping("/sysmanagement/sys-oper-log")
@Api(tags = "操作日志记录")
@Validated
public class SysOperLogController {
    @Resource
    private ISysOperLogService sysOperLogService;

    @ApiOperation( value = "删除日志")
    @DeleteMapping("/operlog")
    public JsonVO<String> deleteOperLog(List<Long> operIds) {
        sysOperLogService.removeByIds(operIds);
        return JsonVO.success("删除成功");
    }

}


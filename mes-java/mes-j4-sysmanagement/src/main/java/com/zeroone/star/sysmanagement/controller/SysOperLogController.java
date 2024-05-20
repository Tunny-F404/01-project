package com.zeroone.star.sysmanagement.controller;


import cn.hutool.core.bean.BeanUtil;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.query.j4.sysmanagement.logmanagement.OperationLog.OperationLogQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.j4.sysmanagement.logmanagement.OperationLog.OperationLogVO;
import com.zeroone.star.sysmanagement.annotation.Log;
import com.zeroone.star.sysmanagement.constant.BusinessType;
import com.zeroone.star.sysmanagement.entity.SysOperLog;
import com.zeroone.star.sysmanagement.service.ISysOperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.websocket.server.PathParam;
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
@RequestMapping("/sysmanagement/operlog")
@Api(tags = "操作日志记录")
@Validated
public class SysOperLogController {
    @Resource
    private ISysOperLogService sysOperLogService;

    @ApiOperation( value = "删除日志")
    @DeleteMapping
    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    public JsonVO<String> deleteOperLog(@RequestParam List<Long> operIds) {
        boolean isRemoved = sysOperLogService.removeByIds(operIds);
        if (!isRemoved){
            throw new RuntimeException("删除失败");
        }
        return JsonVO.success("删除成功");
    }

    @ApiOperation( value = "清空日志")
    @DeleteMapping("/clean")
    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    public JsonVO<String> cleanOperLog() {
        sysOperLogService.cleanOperLog();
        return JsonVO.success("清空成功");
    }

    @ApiOperation( value = "分页获取日志")
    @PostMapping ("/page")
    public JsonVO<PageDTO<OperationLogVO>> getOperationLogPage(@RequestBody OperationLogQuery query) {
        if (query == null){
            throw new RuntimeException("参数不能为空");
        }
        PageDTO<SysOperLog> sysOperLogs = sysOperLogService.selectOperLogList(query);
        PageDTO<OperationLogVO> operationLogVOPageDTO = new PageDTO<>();
        BeanUtil.copyProperties(sysOperLogs, operationLogVOPageDTO);
        return JsonVO.success(operationLogVOPageDTO);
    }

    @ApiOperation( value = "获取日志详情")
    @GetMapping("/{operId}")
    public JsonVO<OperationLogVO> getOperationLogDetail(@PathVariable("operId") @Min(value = 1, message = "id最小值为1")Long operId) {
        if (operId == null){
            throw new RuntimeException("参数不能为空");
        }
        SysOperLog sysOperLog = sysOperLogService.selectOperLogById(operId);
        OperationLogVO operationLogVO = new OperationLogVO();
        BeanUtil.copyProperties(sysOperLog, operationLogVO);
        return JsonVO.success(operationLogVO);
    }




}


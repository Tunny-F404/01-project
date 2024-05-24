package com.zeroone.star.orgstructure.controller;

import com.zeroone.star.project.j2.orgstructure.dto.job.JobDTO;
import com.zeroone.star.project.j2.orgstructure.query.job.JobQuery;
import com.zeroone.star.project.vo.JobVO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.j2.orgstructure.job.JobApis;
import com.zeroone.star.project.vo.ResultStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * @author 爱吃猫的鱼 Feng
 * @version 1.0.0
 * @Description: 岗位控制器
 */

@RestController
@Slf4j
@RequestMapping("job")
@Api(tags = "岗位控制器")
public class JobController implements JobApis {
    @Override
    @PostMapping("add-job")
    @ApiOperation("新增岗位")
    public ResultStatus addJob(@RequestBody JobDTO jobDTO) {
        return ResultStatus.SUCCESS;
    }

    @Override
    @DeleteMapping("remove-job")
    @ApiOperation("删除岗位")
    public ResultStatus removeJob(@RequestParam Long[] ids) {
        return ResultStatus.SUCCESS;
    }

    @Override
    @PostMapping("modify-job")
    @ApiOperation("修改岗位")
    public ResultStatus modifyJob(@RequestBody JobDTO jobDTO) {
        return ResultStatus.SUCCESS;
    }

    @Override
    @GetMapping("export-job")
    @ApiOperation("导出岗位")
    public ResponseEntity<byte[]> exportJob(String group, String storageId) {
        return null;
    }

    @Override
    @GetMapping("query-job-names")
    @ApiOperation(value = "获取岗位名称列表", notes = "获取所有岗位的名称列表")
    public JsonVO<List<String>> queryJobNames() {
        return null;
    }

    @Override
    @PostMapping("query-job-list")
    @ApiOperation(value = "获取岗位列表", notes = "通过提供查询条件获取岗位列表")
    public JsonVO<List<JobVO>> queryJobList(@RequestBody @ApiParam(value = "岗位查询条件", required = true) JobQuery jobQuery) {
        return null;
    }

    @Override
    @GetMapping("query-job-detail")
    @ApiOperation(value = "获取指定岗位详情", notes = "通过提供岗位ID获取该岗位的详细信息")
    public JsonVO<JobVO> queryJobDetail(@RequestParam @ApiParam(value = "岗位ID", required = true) Long id) {
        return null;
    }

}

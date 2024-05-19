package com.zeroone.star.orgstructure.controller;

import com.zeroone.star.project.j2.orgstructure.dto.job.JobDTO;
import com.zeroone.star.project.j2.orgstructure.job.JobApis;
import com.zeroone.star.project.vo.ResultStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 爱吃猫的鱼
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

}

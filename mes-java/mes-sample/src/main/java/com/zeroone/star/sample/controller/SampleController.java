package com.zeroone.star.sample.controller;


import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.project.sample.SampleApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sample.service.ISampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

/**
 * <p>
 * 演示示例表 前端控制器
 * </p>
 * @author awei
 * @since 2024-05-10
 */
@RestController
@RequestMapping("sample")
@Api(tags = "示例接口")
@Validated
public class SampleController implements SampleApis {

    @Resource
    ISampleService sampleService;

    @ApiOperation(value = "分页查询")
    @GetMapping("query-all")
    @Override
    public JsonVO<PageDTO<SampleDTO>> queryAll(@Validated SampleQuery condition) {
        return JsonVO.success(sampleService.listAll(condition));
    }

    @Override
    public JsonVO<SampleDTO> queryById(int id) {
        return JsonVO.success(sampleService.getById(id));
    }

    @ApiOperation(value = "根据id查询")
    @GetMapping("query-one")
    public JsonVO<SampleDTO> queryByIdValidated(@Min(value = 1, message = "id最小值为1") int id) {
        return queryById(id);
    }

    @ApiOperation(value = "测试seata")
    @GetMapping("exec-seata")
    public JsonVO<String> execSeata() {
        try {
            sampleService.testSeata();
            return JsonVO.success("操作成功");
        } catch (Exception e) {
            return JsonVO.fail(e.getMessage());
        }
    }
}


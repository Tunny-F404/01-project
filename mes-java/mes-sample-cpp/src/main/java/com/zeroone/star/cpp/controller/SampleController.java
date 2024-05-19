package com.zeroone.star.cpp.controller;

import cn.hutool.core.bean.BeanUtil;
import com.zeroone.star.cpp.service.SampleService;
import com.zeroone.star.project.cpp.SampleApis;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.cpp.SampleDTO;
import com.zeroone.star.project.query.cpp.SampleQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 描述：调用声明式服务示例控制器
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@RestController
@RequestMapping("cpp")
@Api(tags = "C++示例接口")
public class SampleController implements SampleApis {

    @Resource
    SampleService service;

    @GetMapping("query")
    @ApiOperation(value = "查询数据")
    @Override
    public JsonVO<PageDTO<SampleDTO>> queryAll(SampleQuery query) {
        return service.get(BeanUtil.beanToMap(query,false,true));
    }

    @PostMapping("add")
    @ApiOperation(value = "添加数据")
    @Override
    public JsonVO<Long> addData(SampleDTO dto) {
        return service.post(dto);
    }

    @PutMapping("modify")
    @ApiOperation(value = "修改数据")
    @Override
    public JsonVO<Long> modifyData(SampleDTO dto) {
        return null;
    }

    @DeleteMapping("remove")
    @ApiOperation(value = "删除数据")
    @Override
    public JsonVO<Long> removeData(SampleDTO dto) {
        return service.delete(dto.getId());
    }
}

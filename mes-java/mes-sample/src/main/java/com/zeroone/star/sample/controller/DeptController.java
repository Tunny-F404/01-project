package com.zeroone.star.sample.controller;

import com.zeroone.star.project.j1.dept.DeptApis;
import com.zeroone.star.project.j1.dto.dept.DeptTableDTO;
import com.zeroone.star.project.j1.query.dept.DeptQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 描述：TODO
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@RestController
@RequestMapping("dept")
@Api(tags = "部门管理")
public class DeptController implements DeptApis {
    @GetMapping("query-dept-table")
    @ApiOperation(value = "查询部门列表")
    @Override
    public JsonVO<List<DeptTableDTO>> queryDeptList(DeptQuery deptQuery) {
        return null;
    }
}

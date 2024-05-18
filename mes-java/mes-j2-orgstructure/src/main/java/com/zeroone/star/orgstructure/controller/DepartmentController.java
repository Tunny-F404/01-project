package com.zeroone.star.orgstructure.controller;

import com.zeroone.star.project.j2.orgstructure.dept.DepartmentApis;
import com.zeroone.star.project.j2.orgstructure.dto.DepartmentDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description: 部门控制器
 */
@RestController
@RequestMapping("dept")
@Api(tags = "部门控制器")
public class DepartmentController  implements DepartmentApis {


    @Override
    @PostMapping("add-department")
    @ApiOperation("新增部门")
    public JsonVO<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return JsonVO.success(departmentDTO);

    }

    @Override
    @PostMapping("modify-department")
    @ApiOperation("修改部门")
    public JsonVO<Integer> modifyDepartment(@RequestBody DepartmentDTO departmentDTO) {

        return JsonVO.success(1);
    }

    @Override
    @DeleteMapping("remove-department")
    @ApiOperation("删除部门")
    public JsonVO<Integer> removeDepartment(String id) {
        return JsonVO.success(1);
    }
}

package com.zeroone.star.orgstructure.controller;

import com.zeroone.star.orgstructure.service.DepartmentService;
import com.zeroone.star.project.j2.orgstructure.dept.DepartmentApis;
import com.zeroone.star.project.j2.orgstructure.dto.dept.DepartmentDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description: 部门控制器
 */
@RestController
@RequestMapping("dept")
@Api(tags = "部门控制器")
public class DepartmentController  implements DepartmentApis {

    @Resource
    DepartmentService departmentService;


    @Override
    @GetMapping("get-department-tree")
    @ApiOperation("获取部门名称树")
    public JsonVO<DepartmentDTO> getDepartmentNameTree(String id) {
        return JsonVO.success(new DepartmentDTO());
    }
    @Override
    @GetMapping("get-department-list")
    @ApiOperation("获取部门列表(条件)")
    public JsonVO<DepartmentDTO> getDepartmentList() {
        return JsonVO.success(new DepartmentDTO());
    }

    @Override
    @GetMapping("get-department-detail")
    @ApiOperation("获知指定部门详情")
    public JsonVO<DepartmentDTO> getDepartmentDetail(String id) {
        return JsonVO.success(new DepartmentDTO());
    }







    @Override
    @PostMapping("add-department")
    @ApiOperation("新增部门")
    public JsonVO<Long> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        int info = departmentService.execSaveDepartment(departmentDTO);
        if (info == 0) {
            return null;
        }
        return JsonVO.success(departmentDTO.getDeptId());
    }

    @Override
    @PostMapping("modify-department")
    @ApiOperation("修改部门")
        public JsonVO<Integer> modifyDepartment(@RequestBody DepartmentDTO departmentDTO) {
        int info = departmentService.execUpdateDepartment(departmentDTO);
        if (info == 0) {
            return JsonVO.fail(0);
        }
        return JsonVO.success(1);
    }

    @Override
    @DeleteMapping("remove-department")
    @ApiOperation("删除部门")
    public JsonVO<Integer> removeDepartment(@RequestParam Long[] ids) {
        int info = departmentService.execRemoveDepartment(ids);
        if (info == 0) {
            return JsonVO.fail(0);
        }
        return JsonVO.success(1);
    }


}

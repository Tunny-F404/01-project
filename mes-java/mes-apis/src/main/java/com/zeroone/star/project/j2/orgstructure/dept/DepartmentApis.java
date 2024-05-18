package com.zeroone.star.project.j2.orgstructure.dept;

import com.zeroone.star.project.j2.orgstructure.dto.DepartmentDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description: TODO
 */
public interface DepartmentApis {

    //新增部门
    JsonVO<DepartmentDTO> addDepartment(DepartmentDTO departmentDTO);

    //修改部门
    JsonVO<Integer> modifyDepartment(DepartmentDTO departmentDTO);

    //删除部门
    JsonVO<Integer> removeDepartment(String id);





}

package com.zeroone.star.project.j2.orgstructure.dept;

import com.zeroone.star.project.j2.orgstructure.dto.DepartmentDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description: DepartmentApis
 */
public interface DepartmentApis {

    //获取部门名称树
    JsonVO<DepartmentDTO> getDepartmentNameTree(String id);

    //获取部门列表(条件)
    JsonVO<DepartmentDTO> getDepartmentList();

    //获取部门详情
    JsonVO<DepartmentDTO> getDepartmentDetail(String id);

    //新增部门
    JsonVO<DepartmentDTO> addDepartment(DepartmentDTO departmentDTO);

    //修改部门
    JsonVO<Integer> modifyDepartment(DepartmentDTO departmentDTO);

    //删除部门
    JsonVO<Integer> removeDepartment(String id);





}

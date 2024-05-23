package com.zeroone.star.project.j2.orgstructure.dept;


import com.zeroone.star.project.j2.orgstructure.dto.dept.DepartmentDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * @author 宵夜、夕秋z
 * @version 1.0.0
 * @Description: DepartmentApis
 */
public interface DepartmentApis {

    //获取部门名称树
    JsonVO<DepartmentDTO> getDepartmentNameTree(String id);

    //获取部门列表(条件)
    JsonVO<DepartmentDTO> getDepartmentList();

    //获取部门详情
    JsonVO<DepartmentDTO> getDepartmentDetail(int id);



    //新增部门
    JsonVO<String> addDepartment(DepartmentDTO departmentDTO);

    //修改部门
    JsonVO<String> modifyDepartment(DepartmentDTO departmentDTO);

    //删除部门
    JsonVO<String> removeDepartment(int id);



}

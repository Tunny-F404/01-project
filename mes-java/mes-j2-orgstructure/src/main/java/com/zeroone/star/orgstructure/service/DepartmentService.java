package com.zeroone.star.orgstructure.service;

import com.zeroone.star.orgstructure.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.j2.orgstructure.dto.dept.DepartmentDTO;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 宵夜
 * @since 2024-05-22
 */
public interface DepartmentService extends IService<Department> {

    /**
     * 新增部门
     * @param departmentDTO
     * @return
     */
        int saveDepartment(DepartmentDTO departmentDTO);

    /**
     * 修改部门
     * @param departmentDTO
     * @return
     */
    int updateDepartment(DepartmentDTO departmentDTO);

    /**
     * 删除部门
     * @param id
     * @return
     */
    int removeDepartment(int id);

}

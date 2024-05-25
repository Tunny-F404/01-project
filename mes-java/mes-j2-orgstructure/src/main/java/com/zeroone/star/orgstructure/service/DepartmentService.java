package com.zeroone.star.orgstructure.service;

import com.zeroone.star.orgstructure.entity.DepartmentDO;
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
public interface DepartmentService extends IService<DepartmentDO> {

    /**
     * 新增部门
     *
     * @param departmentDTO
     * @return
     */
        Integer execSaveDepartment(DepartmentDTO departmentDTO);

    /**
     * 修改部门
     * @param departmentDTO
     * @return
     */
    Integer execUpdateDepartment(DepartmentDTO departmentDTO);

    /**
     * 删除部门
     * @param ids
     * @return
     */
    Integer execRemoveDepartment(Long[] ids);

}

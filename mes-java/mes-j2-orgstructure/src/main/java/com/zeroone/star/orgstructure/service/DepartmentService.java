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
     * 获取部门名称树
     * @param
     * @return
     */
    List<DepartmentTreeVO> getDepartmentNameTree(DepartmentQuery query);


    /**
     * 获取部门列表
     * @param query
     * @return
     */
    PageDTO<DepartmentDTO> getDepartmentList(DepartmentQuery query);

    /**
     * 获取获知指定部门详情
     * @param id
     * @return
     */
    DepartmentDTO getDepartmentDetail(int id);


    /**
     * 新增部门
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

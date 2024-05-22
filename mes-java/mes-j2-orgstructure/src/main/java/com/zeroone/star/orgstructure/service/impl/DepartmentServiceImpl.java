package com.zeroone.star.orgstructure.service.impl;

import cn.hutool.core.date.DateTime;
import com.zeroone.star.orgstructure.entity.Department;
import com.zeroone.star.orgstructure.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j2.orgstructure.dto.dept.DepartmentDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 宵夜
 * @since 2024-05-22
 */

@Mapper(componentModel = "spring")
interface MsDepartmentMapper {
    /**
     * 将department转换为departmentDTO
     * @param departmentDTO
     * @return
     */
    Department departmentDTOToDepartment(DepartmentDTO departmentDTO);
}


@Service
public class DepartmentServiceImpl extends ServiceImpl<com.zeroone.star.orgstructure.mapper.DepartmentMapper, Department> implements DepartmentService {

    @Resource
    MsDepartmentMapper msDepartmentMapper;

    @Override
    public int saveDepartment(DepartmentDTO departmentDTO) {
        Department department = msDepartmentMapper.departmentDTOToDepartment(departmentDTO);
        department.setCreateTime(LocalDateTime.now());
        return  baseMapper.insert(department);
    }

    @Override
    public int updateDepartment(DepartmentDTO departmentDTO) {
        Department department = msDepartmentMapper.departmentDTOToDepartment(departmentDTO);
        department.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(department);
    }

    @Override
    public int removeDepartment(int id) {
        return   baseMapper.deleteById(id);

    }
}

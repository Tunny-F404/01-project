package com.zeroone.star.orgstructure.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.orgstructure.entity.Department;
import com.zeroone.star.orgstructure.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.dept.DepartmentDTO;
import com.zeroone.star.project.j2.orgstructure.query.dept.DepartmentQuery;
import com.zeroone.star.project.vo.JsonVO;
import org.apache.commons.lang.enums.Enum;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.Query;
import java.time.LocalDateTime;
import java.util.EnumMap;

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
     * @param department
     * @return
     */
    DepartmentDTO departmentOToDepartmentDTO(Department department);
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

    //获取部门列表
    @Override
    public PageDTO<DepartmentDTO> getDepartmentList(DepartmentQuery query) {
        //构建列表查询对象(DO)
        Page<Department> page = new Page<>(query.getPageIndex(), query.getPageSize());
        //构建查询条件
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        //如果存在合法参数则添加条件
        if(query.getDeptName() != null) queryWrapper.like("dept_name",query.getDeptName());
        if(query.getOrderNum() != null)queryWrapper.eq("order_num",query.getOrderNum());
        if(query.getStatus() >= 0)queryWrapper.eq("status",query.getStatus());
        if(query.getCreateTime() != null)queryWrapper.eq("create_by",query.getCreateTime());
        //执行查询
        Page<Department> res = baseMapper.selectPage(page,queryWrapper);
        //将结果转化为DTO
        if(res == null) return null;//result为空表示查询失败
        return PageDTO.create(res, msDepartmentMapper::departmentOToDepartmentDTO);
    }

    //根据id获取指定部门所有信息
    @Override
    public DepartmentDTO getDepartmentDetail(int id) {
        //执行查询
        Department department = baseMapper.selectById(id);
        if(department != null){
            return msDepartmentMapper.departmentOToDepartmentDTO(department);
        }
        return null;//null表示查询失败没有该条数据
    }

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

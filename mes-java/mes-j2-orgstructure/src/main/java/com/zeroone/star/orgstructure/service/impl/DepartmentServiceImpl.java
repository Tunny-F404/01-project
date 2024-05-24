package com.zeroone.star.orgstructure.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.orgstructure.entity.DepartmentDO;
import com.zeroone.star.orgstructure.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j2.orgstructure.dto.dept.DepartmentDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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
     *
     * @param departmentDTO
     * @return
     */
    DepartmentDO departmentDTOToDepartment(DepartmentDTO departmentDTO);
}


@Service
public class DepartmentServiceImpl extends ServiceImpl<com.zeroone.star.orgstructure.mapper.DepartmentMapper, DepartmentDO> implements DepartmentService {

    @Resource
    MsDepartmentMapper msDepartmentMapper;

    @Override
    public int saveDepartment(DepartmentDTO departmentDTO) {
        DepartmentDO departmentDO = msDepartmentMapper.departmentDTOToDepartment(departmentDTO);
        departmentDO.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(departmentDO);
    }

    @Override
    public int updateDepartment(DepartmentDTO departmentDTO) {
        DepartmentDO departmentDO = msDepartmentMapper.departmentDTOToDepartment(departmentDTO);
        departmentDO.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(departmentDO);
    }

    @Override
    public int removeDepartment(int id) {
        //查询所有parentId为id的部门
        QueryWrapper<DepartmentDO> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("parent_id", id);
        List<DepartmentDO> departmentDOS = baseMapper.selectList(objectQueryWrapper);
        if (departmentDOS.size() != 0) {
            //删除父id为id的部门
            for (DepartmentDO departmentDO : departmentDOS) {
                baseMapper.deleteById(departmentDO.getDeptId());
            }
        }
        return baseMapper.deleteById(id);
    }

    }

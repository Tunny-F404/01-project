package com.zeroone.star.orgstructure.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.orgstructure.entity.DepartmentDO;
import com.zeroone.star.orgstructure.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j2.orgstructure.dto.dept.DepartmentDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
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
    public Integer execSaveDepartment(DepartmentDTO departmentDTO) {
        DepartmentDO departmentDO = msDepartmentMapper.departmentDTOToDepartment(departmentDTO);
        QueryWrapper<DepartmentDO> wrapper = new QueryWrapper<>();
        wrapper.eq("dept_name", departmentDO.getDeptName());
        wrapper.eq("parent_id", departmentDO.getParentId());
        if (baseMapper.selectList(wrapper) != null) {
            departmentDO.setCreateTime(LocalDateTime.now());
            int insert = baseMapper.insert(departmentDO);
            departmentDTO.setDeptId(departmentDO.getDeptId());
            return insert;
        }
        return null;

    }
    @Override
    public Integer execUpdateDepartment(DepartmentDTO departmentDTO) {
        //判断仓库是否存在
        QueryWrapper<DepartmentDO> wrapper = new QueryWrapper<>();
        wrapper.eq("dept_id", departmentDTO.getDeptId());
        List<DepartmentDO> departmentDOS = baseMapper.selectList(wrapper);
        if(departmentDOS.size() > 0){
            DepartmentDO departmentDO = msDepartmentMapper.departmentDTOToDepartment(departmentDTO);
            departmentDO.setUpdateTime(LocalDateTime.now());
            return baseMapper.updateById(departmentDO);
        }
        return 0;
    }

    @Override
    @Transactional
    public Integer execRemoveDepartment(Long[] ids) {
        //遍历每一个要删除的部门
        for(Long id : ids ){
            //查询所有parentId为id的部门
            QueryWrapper<DepartmentDO> wrapper = new QueryWrapper<>();
            wrapper.eq("parent_id", id);
            List<DepartmentDO> departmentDOS = baseMapper.selectList(wrapper);
            if (departmentDOS.size() != 0) {
                //删除父id为id的部门
                for (DepartmentDO departmentDO : departmentDOS) {
                    baseMapper.deleteById(departmentDO.getDeptId());
                }
            }
        }

        return baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    }

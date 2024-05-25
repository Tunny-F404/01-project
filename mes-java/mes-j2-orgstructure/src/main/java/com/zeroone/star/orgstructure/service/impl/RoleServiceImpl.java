package com.zeroone.star.orgstructure.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.orgstructure.entity.RoleDO;
import com.zeroone.star.orgstructure.mapper.RoleMapper;
import com.zeroone.star.orgstructure.service.IRoleService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleListDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RolePermissionsDTO;
import com.zeroone.star.project.j2.orgstructure.query.role.RoleConditionQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * role对应的MapStructMapper接口
 */
@Mapper(componentModel = "spring")
interface MsRoleMapper {
    /**
     * 将roleDO转为 roleDTO
     *
     * @param roleDO
     * @return
     */
    RoleListDTO roleDOToRoleDTO(RoleDO roleDO);

    List<RoleListDTO> roleDOToRoleDTOList(List<RoleDO> roleDOList);
}

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author 天衍土豆
 * @since 2024-05-24
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleDO> implements IRoleService {

    @Resource
    private MsRoleMapper msRoleMapper;

    /**
     * 查询全部角色列表
     *
     * @return 角色集合
     * @author 天衍土豆
     */
    @Override
    public List<RoleListDTO> listRoles() {
        log.info("查询全部列表");
        List<RoleDO> result = baseMapper.selectList(null);
        return msRoleMapper.roleDOToRoleDTOList(result);
    }

    @Override
    public PageDTO<RoleListDTO> listPageRoles(RoleConditionQuery condition) {
        //构建分页查询对象
        Page<RoleDO> page = new Page<>(condition.getPageIndex(), condition.getPageSize());
        //构建分页查询条件
        LambdaQueryWrapper<RoleDO> queryWrapper = new LambdaQueryWrapper();
        if (StringUtils.isNotEmpty(condition.getRoleName())) {
            queryWrapper.like(RoleDO::getRoleName, condition.getRoleName());
        }
        if (StringUtils.isNotEmpty(condition.getRoleKey())) {
            queryWrapper.like(RoleDO::getRoleKey, condition.getRoleKey());
        }
        if (StringUtils.isNotEmpty(condition.getStatus())) {
            queryWrapper.eq(RoleDO::getStatus, condition.getStatus());
        }
        if (StringUtils.isNotEmpty(condition.getStartTime()) && StringUtils.isNotEmpty(condition.getEndTime())){
            queryWrapper.between(RoleDO::getCreateTime, condition.getStartTime() , condition.getEndTime());
        }

        //执行查询
        Page<RoleDO> result = baseMapper.selectPage(page, queryWrapper);
        return PageDTO.create(result, src -> msRoleMapper.roleDOToRoleDTO(src));
    }

    @Override
    public RoleDTO getById(Integer id) {
        return null;
    }

    @Override
    public RolePermissionsDTO getPermissions(Integer id) {
        return null;
    }

    @Override
    public RolePermissionsDTO updatePermissions(Integer id) {
        return null;
    }
}

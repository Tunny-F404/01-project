package com.zeroone.star.orgstructure.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.nacos.shaded.io.grpc.Internal;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zeroone.star.orgstructure.entity.RoleDo;
import com.zeroone.star.orgstructure.mapper.RoleMapper;
import com.zeroone.star.orgstructure.service.RoleService;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleAddDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleModifyDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleStatusModifyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 描述：Role 角色服务接口
 *
 * @author 0xu0
 * @version 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    /**
     * 添加角色
     *
     * @param roleDTO
     * @return
     * @author 0xu0
     */
    @Override
    public Integer addRole(RoleAddDto roleDTO) {
        RoleDo roleDo = new RoleDo();
        System.out.println(roleDTO.toString());
        //复制给Do
        BeanUtil.copyProperties(roleDTO, roleDo, true);
        //设置创建者，时间
        roleDo.setCreateTime(new Date());
        roleDo.setDelFlag("0");
        roleMapper.insert(roleDo);
        Integer roleId = roleDo.getRoleId();
        return roleId;
    }

    /***
     * 修改角色状态（角色页面，有个开关符号，控制停用和启用）
     * @author 0xu0
     * @param roleStatusModifyDto
     * @return
     */
    public Integer modifyRoleStatus(RoleStatusModifyDto roleStatusModifyDto) {
        UpdateWrapper updateRoleStatus = new UpdateWrapper();
        updateRoleStatus.eq("role_id", roleStatusModifyDto.getRoleId());
        RoleDo roleDo = new RoleDo();
        //复制给Do
        BeanUtil.copyProperties(roleStatusModifyDto, roleDo, true);
        //设置创建者，时间
        roleDo.setUpdateTime(new Date());
        int update = roleMapper.update(roleDo, updateRoleStatus);
        if(update>0){
            return update;
        }
        return 0;
    }


    /**
     * 删除角色，支持批量删除
     *
     * @param ids
     * @return
     * @author 0xu0
     */
    public Integer deleteRoles(@RequestParam List<String> ids) {
        return roleMapper.deleteBatchIds(ids);
    }

    /**
     * 修改角色信息
     *
     * @param roleDTO
     * @return
     */
    public Integer modifyRoleInfo(RoleModifyDto roleDTO) {
        UpdateWrapper updateRoleInfo = new UpdateWrapper();
        updateRoleInfo.eq("role_id", roleDTO.getRoleId());
        RoleDo roleDo = new RoleDo();
        //复制给Do
        BeanUtil.copyProperties(roleDTO, roleDo, true);
        //设置创建者，时间
        roleDo.setUpdateTime(new Date());
        return roleMapper.update(roleDo, updateRoleInfo);
    }

}

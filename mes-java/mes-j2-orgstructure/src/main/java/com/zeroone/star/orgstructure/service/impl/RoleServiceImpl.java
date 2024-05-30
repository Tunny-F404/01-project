package com.zeroone.star.orgstructure.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zeroone.star.orgstructure.entity.RoleDo;
import com.zeroone.star.orgstructure.entity.UserDO;
import com.zeroone.star.orgstructure.entity.UserRoleDO;
import com.zeroone.star.orgstructure.mapper.RoleMapper;
import com.zeroone.star.orgstructure.mapper.UserConvertMapper;
import com.zeroone.star.orgstructure.mapper.UserRoleMapper;
import com.zeroone.star.orgstructure.service.RoleService;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
/*import com.zeroone.star.project.components.user.UserDTO;*/
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleAddDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleModifyDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleStatusModifyDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.UserRoleDTO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    UserRoleMapper userRoleMapper;
    @Resource
    EasyExcelComponent excel;
    @Resource
    private UserConvertMapper userConvertMapper;

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
        if (update > 0) {
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


    /*
    * 查找该角色所分配的用户
    * */
    public List<UserRoleDTO> getUsersByRoleId(Long roleId, int offset, int limit) {
        List<UserDO> userDOList = userRoleMapper.getUsersByRoleId(roleId, offset, limit);
        return userDOList.stream()
                .map(userConvertMapper::userDOToUserDTO)
                .collect(Collectors.toList());
    }

    /*
     * 取消授权
     * */
    @Override
    public int deleteAuthUsers(Long roleId, Long[] userIds) {
        return userRoleMapper.deleteUserRoleInfos(roleId, userIds);
    }

    /*
     * 批量添加用户授权
     * */
    @Override
    public int insertAuthUsers(Long roleId, Long[] userIds) {
        // 新增用户与角色管理
        List<UserRoleDO> list = new ArrayList<>();
        for (Long userId : userIds) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        return userRoleMapper.batchUserRole(list);
    }


    @SneakyThrows
    @Override
    public ResponseEntity<byte[]> downloadExcel() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("role_id", "role_name", "role_key", "role_sort", "data_scope", "status");
        List<RoleDo> roles = roleMapper.selectList(queryWrapper);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        excel.export("role", out, RoleDo.class, roles);
        byte[] bytes = out.toByteArray();
        out.close();
        HttpHeaders headers = new HttpHeaders();
        String filename = "report-" + DateTime.now().toString("yyyyHHddHHmmssS") + ".xlsx";
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
/*
        headers.setContentType(MediaType.valueOf("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
*/
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

}

package com.zeroone.star.project.j2.orgstructure;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.RoleDTO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * @description: 查看角色列表接口
 * @author: 魏玉石
 * @data: 2024/5/18
 */
public interface RoleApis {
    //查询全部列表
    JsonVO<List<RoleDTO>> queryRoles();

    //分页查询
    JsonVO<List<RoleDTO>> queryRolePage(RoleDTO condition);

    //获取角色详情
    JsonVO<RoleDTO> queryRole(Integer id);

    //设置数据权限
    JsonVO<List<RoleDTO>> modifyRole(Integer id);
}

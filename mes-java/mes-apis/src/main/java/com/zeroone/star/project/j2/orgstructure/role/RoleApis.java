package com.zeroone.star.project.j2.orgstructure.role;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * 描述：角色模块接口
 *
 * @author 0xu0
 * @version 1.0.0
 */
public interface RoleApis {

    public JsonVO<List<RoleDTO>> queryRoles();

    /**
     * 获取角色列表(条件+分页)
     */

    public JsonVO<List<RoleDTO>> queryRolePage(RoleDTO condition, PageDTO<RoleDTO> pageDTO);

    /**
     * 获取角色详情
     */

    public JsonVO<RoleDTO> queryRole(Integer id);
    /**
     * 设置数据权限
     */

    public JsonVO<List<RoleDTO>> modifyRole(Integer id);

    /**
     * 添加角色
     * @author 0xu0
     * @param roleDTO
     * @return
     */

    public JsonVO<RoleDTO> addRole( RoleDTO roleDTO);
    /***
     * 修改角色状态（角色页面，有个开关符号，控制停用和启用）
     * @author 0xu0
     * @param status
     * @return
     */

    public JsonVO<String> modifyRoleStatus( String status);


    /**
     * 删除角色，支持批量删除
     * @author 0xu0
     * @param id
     * @return
     */

    public JsonVO<Long[]> deleteRoles( Long[] id);
    /**
     * 修改角色信息
     * @param roleDTO
     * @return
     */

    public JsonVO<RoleDTO> modifyRoleInfo( RoleDTO roleDTO);
}

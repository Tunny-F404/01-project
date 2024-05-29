package com.zeroone.star.project.j2.orgstructure.role;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleAddDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleModifyDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleStatusModifyDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述：角色模块接口
 *
 * @author 0xu0、天衍土豆 迷
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
     *
     * @param roleDTO
     * @return
     * @author 0xu0
     */

    public JsonVO<Integer> addRole(RoleAddDto roleDTO);

    /***
     * 修改角色状态（角色页面，有个开关符号，控制停用和启用）
     * @author 0xu0
     * @param roleStatusModifyDto
     * @return
     */

    public JsonVO<Integer> modifyRoleStatus(RoleStatusModifyDto roleStatusModifyDto);


    /**
     * 删除角色，支持批量删除
     *
     * @param ids
     * @return
     * @author 0xu0
     */

    public JsonVO<List<String>> deleteRoles(List<String> ids);

    /**
     * 修改角色信息
     *
     * @param roleDTO
     * @return
     */

    public JsonVO<Integer> modifyRoleInfo(RoleModifyDto roleDTO);

    /*
     * 获取角色分配用户列表（条件+分页）
     * */
/*
    public JsonVO<List<RoleDTO>> queryAllocatedList(Long roleId, int page, int size);
*/

    /*
     * 添加授权
     * */
    public JsonVO<RoleDTO> addAuth(Long roleId, Long[] userIds);


    /*
     * 取消授权
     * */
    //public JsonVO<Integer> cancelAuthUser(RoleDTO roleDTO);

    /*
     * 批量取消授权（支持批量）
     * */
    public JsonVO<Integer> cancelAuthUsers(Long roleId, Long[] userIds);

    /*
     * 导出角色
     * */
    public ResponseEntity<byte[]> export();

}

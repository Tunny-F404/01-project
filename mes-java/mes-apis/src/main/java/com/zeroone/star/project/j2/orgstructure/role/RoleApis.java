package com.zeroone.star.project.j2.orgstructure.role;


import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RoleApis {

    /*
     * 获取角色分配用户列表（条件+分页）
     * */
    public JsonVO<List<RoleDTO>> queryAllocatedList(RoleDTO roleDTO, PageDTO<RoleDTO> pageDTO);

    /*
     * 添加授权
     * */
    public JsonVO<RoleDTO> addAuth(Long roleId, Long[] userIds);

    /*
     * 取消授权（支持批量）
     * */
    public JsonVO<List<RoleDTO>> cancelAuthUser(Long roleId,Long[] userIds);

    /*
     * 导出角色
     * */
    public ResponseEntity<byte[]> export();

}

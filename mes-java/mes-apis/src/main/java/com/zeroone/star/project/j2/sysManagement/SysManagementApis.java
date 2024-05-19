package com.zeroone.star.project.j2.sysManagement;
import com.zeroone.star.project.j2.sysManagement.dto.SysManagementDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * @author 熠
 * @version 1.0.0
 * @Description: TODO
 */

public interface SysManagementApis {
    //添加资源
    JsonVO<SysManagementDTO> addResource(SysManagementDTO resourceDTO);

    //删除资源
    JsonVO<Integer> removeResource(String id);

    //修改资源
    JsonVO<Integer> modifyResource(SysManagementDTO resourceDTO);
}

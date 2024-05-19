package com.zeroone.star.project.j2.sysmanagement;
import com.zeroone.star.project.j2.sysmanagement.dto.SysmanagementDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * @author 熠
 * @version 1.0.0
 * @Description: TODO
 */

public interface SysmanagementApis {
    //添加资源
    JsonVO<SysmanagementDTO> addResource(SysmanagementDTO resourceDTO);

    //删除资源
    JsonVO<Integer> removeResource(String id);

    //修改资源
    JsonVO<Integer> modifyResource(SysmanagementDTO resourceDTO);
}

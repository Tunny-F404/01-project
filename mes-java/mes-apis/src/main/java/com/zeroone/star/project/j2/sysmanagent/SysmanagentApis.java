package com.zeroone.star.project.j2.sysmanagent;
import com.zeroone.star.project.j2.sysmanagent.dto.SysmanagentDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * @author 熠
 * @version 1.0.0
 * @Description: TODO
 */

public interface SysmanagentApis {
    //添加资源
    JsonVO<SysmanagentDTO> addResource(SysmanagentDTO resourceDTO);

    //删除资源
    JsonVO<Integer> removeResource(String id);

    //修改资源
    JsonVO<Integer> modifyResource(SysmanagentDTO resourceDTO);
}

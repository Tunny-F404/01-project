package com.zeroone.star.project.j2.sysmanagement;

import com.zeroone.star.project.j2.sysmanagent.dto.MenuDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * @author 熠
 * @version 1.0.0
 * @Description: TODO
 */

public interface MenuApis {
    //添加资源
    JsonVO<MenuDTO> addResource(MenuDTO resourceDTO);

    //删除资源
    JsonVO<Integer> removeResource(String id);

    //修改资源
    JsonVO<Integer> modifyResource(MenuDTO resourceDTO);
}

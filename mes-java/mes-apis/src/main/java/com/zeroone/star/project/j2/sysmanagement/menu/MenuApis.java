package com.zeroone.star.project.j2.sysmanagement.menu;

import cn.hutool.core.lang.tree.TreeNode;
import com.zeroone.star.project.j2.sysmanagent.dto.menu.MenuDTO;
import com.zeroone.star.project.j2.sysmanagent.query.menu.MenuConditionQuery;
import com.zeroone.star.project.j2.sysmanagent.vo.ResourceDetailsVO;
import com.zeroone.star.project.j2.sysmanagent.vo.ResourceVO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * @author 熠 Di
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

    //获取资源名称树
    JsonVO<TreeNode<String>> getResourceNameTree();

    //根据条件获取资源列表
    JsonVO<List<ResourceVO>> getResourceListByCondition(MenuConditionQuery menuConditionQuery);

    //根据资源路径获取资源详情
    JsonVO<ResourceDetailsVO> getResourceDetails(String path);
}

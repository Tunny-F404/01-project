package com.zeroone.star.sysmanagement.controller;

import cn.hutool.core.lang.tree.TreeNode;
import com.zeroone.star.project.j2.sysmanagement.menu.MenuApis;
import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;
import com.zeroone.star.project.j2.sysmanagement.query.menu.MenuConditionQuery;
import com.zeroone.star.project.j2.sysmanagement.query.menu.MenuQuery;
import com.zeroone.star.project.j2.sysmanagement.vo.ResourceDetailsVO;
import com.zeroone.star.project.j2.sysmanagement.vo.ResourceVO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanagement.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 熠 Di
 * @version 1.0.0
 * @Description: 测试控制器
 */
@RestController
@RequestMapping("sys")
@Api(tags = "测试控制器")
public class MenuController implements MenuApis {

    @Resource
    private MenuService menuService;

    @PostMapping("add-resource")
    @ApiOperation("新增资源")
    @Override
    public JsonVO<MenuDTO> addMenu(@RequestBody MenuDTO sysmanagementDTO) {

        if(sysmanagementDTO.getMenu_id() != null&&sysmanagementDTO.getParent_id() != null){
            if(sysmanagementDTO.getMenu_name() == null){
                //TODO:提示：菜单名不能为空
                return JsonVO.fail(sysmanagementDTO);
            }
            if(sysmanagementDTO.getOrder_num() == null){
                //TODO:提示：排序不能为空
                return JsonVO.fail(sysmanagementDTO);
            }
            if(sysmanagementDTO.getQuery() == null){
                //TODO:提示：路径不能为空
                return JsonVO.fail(sysmanagementDTO);
            }
            menuService.addMenu(sysmanagementDTO);
        }
        return JsonVO.fail(sysmanagementDTO);
    }

    @PostMapping("remove-resource")
    @ApiOperation("删除资源")
    @Override
    public JsonVO<MenuQuery> removeMenu(MenuQuery menu_id) {
        if(menu_id == null) {
            return null;
        }
        return JsonVO.success(menuService.removeMenu(MenuQuery menu_id));
    }

    @PostMapping("modify-resource")
    @ApiOperation("修改资源")
    @Override
    public JsonVO<Integer> modifyMenu(MenuDTO menuDTO) {
        if(menuDTO.getMenu_id() != null){
            menuService.modifyMenu(menuDTO);
        }
        return null;
    }

    @GetMapping("/get-resource-name-tree")
    @ApiOperation("获取资源名称树")
    @Override
    public JsonVO<TreeNode<String>> getResourceNameTree() {
        return null;
    }

    @PostMapping("/get-resource-list")
    @ApiOperation("根据条件获取资源列表")
    @Override
    public JsonVO<List<ResourceVO>> getResourceListByCondition(@RequestBody MenuConditionQuery menuConditionQuery) {
        List<ResourceVO> list = new ArrayList<>();
        return JsonVO.success(list);
    }

    @GetMapping("/get-resource-details/{path}")
    @ApiOperation("获取资源详情")
    @Override
    public JsonVO<ResourceDetailsVO> getResourceDetails(@PathVariable String path) {
        return null;
    }
}

package com.zeroone.star.com.zeroone.star.sysmanagement.controller;

import cn.hutool.core.lang.tree.TreeNode;
import com.zeroone.star.project.j2.sysmanagement.menu.MenuApis;
import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;
import com.zeroone.star.project.j2.sysmanagement.query.menu.MenuConditionQuery;
import com.zeroone.star.project.j2.sysmanagement.vo.ResourceDetailsVO;
import com.zeroone.star.project.j2.sysmanagement.vo.ResourceVO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.com.zeroone.star.sysmanagement.service.MenuService;
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
@Api(tags = "菜单管理控制器")
public class MenuController implements MenuApis {

    @Resource
    private MenuService menuService;
    private boolean menu_id;

    @PostMapping("add-resource")
    @ApiOperation("新增资源")
    @Override
    public JsonVO<MenuDTO> addMenu(@RequestBody MenuDTO sysmanagementDTO) {
        int i = menuService.addMenu(sysmanagementDTO);
        if(i != 0){
            return JsonVO.success(sysmanagementDTO);
        }
        return JsonVO.fail(sysmanagementDTO);
    }

    @PostMapping("remove-resource")
    @ApiOperation("删除资源")
    @Override
    public JsonVO<String> removeMenu(int menu_id) {
        int i = menuService.removeMenu(menu_id);
        if(i != 0){
            return JsonVO.success("删除成功");
        }
        return JsonVO.fail("未找到需要删除的资源");
    }

    @PostMapping("modify-resource")
    @ApiOperation("修改资源")
    @Override
    public JsonVO<String> modifyMenu(MenuDTO menuDTO) {
        int i = menuService.modifyMenu(menuDTO);
        if(i != 0){
            return JsonVO.success("修改成功");
        }
        return JsonVO.fail("修改失败");
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

    public boolean getMenu_id() {
        return menu_id;
    }
}

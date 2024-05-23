package com.zeroone.star.sysmanagement.controller;

import cn.hutool.core.lang.tree.TreeNode;
import com.zeroone.star.project.j2.sysmanagement.menu.MenuApis;
import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;
import com.zeroone.star.project.j2.sysmanagement.query.menu.MenuConditionQuery;
import com.zeroone.star.project.j2.sysmanagement.vo.ResourceDetailsVO;
import com.zeroone.star.project.j2.sysmanagement.vo.ResourceVO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("add-resource")
    @ApiOperation("新增资源")
    @Override
    public JsonVO<MenuDTO> addResource(@RequestBody MenuDTO sysmanagentDTO) {
        return JsonVO.success(sysmanagentDTO);
    }

    @PostMapping("remove-resource")
    @ApiOperation("删除资源")
    @Override
    public JsonVO<Integer> removeResource(String id) {
        return JsonVO.success(1);
    }

    @PostMapping("modify-resource")
    @ApiOperation("修改资源")
    @Override
    public JsonVO<Integer> modifyResource(MenuDTO resourceDTO) {
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

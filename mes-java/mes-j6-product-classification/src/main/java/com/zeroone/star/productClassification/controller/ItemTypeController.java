package com.zeroone.star.productClassification.controller;

import com.zeroone.star.project.j6.product_classification.dto.ItemTypeDTO;
import com.zeroone.star.project.j6.product_classification.query.ItemTypeQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "物料产品分类管理")
@RestController
@RequestMapping("/mes/md/itemtype")
public class ItemTypeController {
    @ApiOperation("查询分类列表")
    @GetMapping("/list")
    public JsonVO<List<ItemTypeDTO>> list(@ApiParam(value = "查询条件") ItemTypeQuery itemTypeQuery){
        return null;
    }

    @ApiOperation("查询分类详情")
    @GetMapping(value = "/{itemTypeId}")
    public JsonVO<ItemTypeDTO> getInfo(@ApiParam(value = "分类ID") @PathVariable Long itemTypeId){
        return null;
    }

    @ApiOperation("获取树形结构数据")
    @GetMapping("/treeselect")
    public JsonVO<List<ItemTypeDTO>> treeSelect(@ApiParam(value = "查询条件") ItemTypeQuery itemTypeQuery){
        return null;
    }

    @ApiOperation("新增物料产品分类")
    @PostMapping
    public JsonVO<Void> add(@ApiParam(value = "物料分类信息") @Validated @RequestBody ItemTypeDTO itemTypeDto){
        return null;
    }

    @ApiOperation("更新物料产品分类")
    @PutMapping
    public JsonVO<Void> update(@ApiParam(value = "物料分类信息") @Validated @RequestBody ItemTypeDTO itemTypeDto){
        return null;
    }

    @ApiOperation("删除物料产品分类")
    @DeleteMapping("/{itemTypeId}")
    public JsonVO<Void> del(@ApiParam(value = "分类ID") @PathVariable Long itemTypeId){
        return null;

    }

}

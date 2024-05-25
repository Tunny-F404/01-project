package com.zeroone.star.productClassification.controller;

import com.zeroone.star.project.j6.product_classification.ItemTypeApis;
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
public class ItemTypeController implements ItemTypeApis {
    @ApiOperation("查询分类列表")
    @GetMapping("/list")
    @Override
    public JsonVO<List<ItemTypeDTO>> queryItemTypeList(@ApiParam(value = "查询条件") ItemTypeQuery itemTypeQuery) {
        return null;
    }

    @ApiOperation("查询分类详情")
    @GetMapping(value = "/{itemTypeId}")
    @Override
    public JsonVO<ItemTypeDTO> getItemType(@ApiParam(value = "分类ID") @PathVariable Long itemTypeId) {
        return null;
    }

    @ApiOperation("获取树形结构数据")
    @GetMapping("/treeselect")
    @Override
    public JsonVO<List<ItemTypeDTO>> treeSelect(@ApiParam(value = "查询条件") ItemTypeQuery itemTypeQuery) {
        return null;
    }

    @ApiOperation("新增物料产品分类")
    @PostMapping
    @Override
    public JsonVO<Void> addItemType(@ApiParam(value = "物料分类信息") @Validated @RequestBody ItemTypeDTO itemTypeDTO) {
        return null;
    }

    @ApiOperation("更新物料产品分类")
    @PutMapping
    @Override
    public JsonVO<Void> updateItemType(@ApiParam(value = "物料分类信息") @Validated @RequestBody ItemTypeDTO itemTypeDTO) {
        return null;
    }

    @ApiOperation("删除物料产品分类")
    @DeleteMapping("/{itemTypeId}")
    @Override
    public JsonVO<Void> deleteItemType(@ApiParam(value = "分类ID") @PathVariable Long itemTypeId) {
        return null;
    }

}

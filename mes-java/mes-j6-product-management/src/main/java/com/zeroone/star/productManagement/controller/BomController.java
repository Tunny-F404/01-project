package com.zeroone.star.productManagement.controller;

import com.zeroone.star.project.j6.product_management.BomApis;
import com.zeroone.star.project.j6.product_management.dto.BomDTO;
import com.zeroone.star.project.j6.product_management.query.BomQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-management/bom")
@Api(tags = "BOM部分相关接口")
public class BomController implements BomApis {
    @GetMapping("/list")
    @ApiOperation(value = "查询bom列表")
    @Override
    public JsonVO<List<BomDTO>> queryBomList(BomQuery query){
        return null;
    }
    @GetMapping("/add")
    @ApiOperation(value = "新增bom数据")
    @Override
    public JsonVO<String> addBom(BomDTO dto) {
        return null;
    }
    @GetMapping("/update")
    @ApiOperation(value = "修改bom数据")
    @Override
    public JsonVO<String> updateBom(BomDTO dto) {
        return null;
    }
    @GetMapping("/delete")
    @ApiOperation(value = "删除bom数据")
    @Override
    public JsonVO<String> deleteBOM(String bomId) {
        return null;
    }
}

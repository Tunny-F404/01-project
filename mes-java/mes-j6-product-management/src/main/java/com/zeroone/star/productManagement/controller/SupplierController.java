package com.zeroone.star.productManagement.controller;

import com.zeroone.star.project.j6.product_management.SupplierApis;
import com.zeroone.star.project.j6.product_management.dto.ProductSupplierListDTO;
import com.zeroone.star.project.j6.product_management.dto.SupplierDTO;
import com.zeroone.star.project.j6.product_management.dto.SupplierListDTO;
import com.zeroone.star.project.j6.product_management.query.SupplierListQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-management/suppliers")
@Api(tags = "关联供应商相关接口")
public class SupplierController implements SupplierApis {
    @GetMapping("/list")
    @ApiOperation(value = "查询关联供应商列表")
    @Override
    public JsonVO<List<SupplierDTO>> querySupplierList(SupplierListQuery query) {
        return null;
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加关联供应商")
    @Override
    public JsonVO<String> addSupplierList(@RequestBody SupplierListDTO dto) {
        return null;
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新关联供应商")
    @Override
    public JsonVO<String> updateSupplier(SupplierDTO dto) {
        return null;
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除关联供应商")
    @Override
    public JsonVO<String> deleteBatchSupplier(ProductSupplierListDTO dto) {
        return null;
    }
}

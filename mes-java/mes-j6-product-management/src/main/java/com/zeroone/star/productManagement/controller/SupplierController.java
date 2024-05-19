package com.zeroone.star.productManagement.controller;

import com.zeroone.star.project.j6.product_management.SupplierApis;
import com.zeroone.star.project.j6.product_management.dto.ProductSupplierListDTO;
import com.zeroone.star.project.j6.product_management.dto.SupplierDTO;
import com.zeroone.star.project.j6.product_management.dto.SupplierListDTO;
import com.zeroone.star.project.j6.product_management.query.SupplierListQuery;
import com.zeroone.star.project.j6.product_management.vo.SupplierVO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-management/suppliers")
@ApiModel(description = "关联供应商相关接口")
public class SupplierController implements SupplierApis {
    @GetMapping("/list")
    @ApiModelProperty(value = "查询关联供应商列表", notes = "根据查询条件查询关联供应商列表")
    @Override
    public JsonVO<List<SupplierVO>> querySupplierList(SupplierListQuery query) {
        return null;
    }

    @PostMapping("/add")
    @ApiModelProperty(value = "添加关联供应商", notes = "添加多个关联供应商")
    @Override
    public JsonVO<String> addSupplierList(@RequestBody SupplierListDTO dto) {
        return null;
    }

    @PostMapping("/update")
    @ApiModelProperty(value = "更新关联供应商", notes = "更新关联供应商")
    @Override
    public JsonVO<String> updateSupplier(SupplierDTO dto) {
        return null;
    }

    @PostMapping("/delete")
    @ApiModelProperty(value = "删除关联供应商", notes = "删除关联供应商")
    @Override
    public JsonVO<String> deleteBatchSupplier(ProductSupplierListDTO dto) {
        return null;
    }
}

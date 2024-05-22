package com.zeroone.star.productManagement.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.ProductDTO;
import com.zeroone.star.project.dto.ProductListDTO;
import com.zeroone.star.project.j6.product_management.ProductManageApis;
import com.zeroone.star.project.query.ProductQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-management/product")
@Api(tags = "产品物料相关接口")
public class ProductController implements ProductManageApis {

    @GetMapping("/list")
    @ApiOperation(value = "查询关联供应商列表")
    @Override
    public JsonVO<PageDTO<ProductDTO>> queryAll(ProductQuery query) {
        return null;
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除产品列表")
    @Override
    public JsonVO<String> deleteBatchProducts(ProductListDTO dto) {
        return null;
    }

    @PostMapping("/update")
    @ApiOperation(value = "查询关联供应商列表")
    @Override
    public JsonVO<String> updateProduct(ProductDTO dto) {
        return null;
    }

    @PostMapping("/add")
    @ApiOperation(value = "查询关联供应商列表")
    @Override
    public JsonVO<String> addProduct(ProductDTO dto) {
        return null;
    }

    @GetMapping("/one")
    @ApiOperation(value = "查询关联供应商列表")
    @Override
    public JsonVO<ProductDTO> queryByID(Long id) {
        return null;
    }
}

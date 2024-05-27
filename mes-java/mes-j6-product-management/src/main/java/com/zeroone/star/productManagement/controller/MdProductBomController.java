package com.zeroone.star.productManagement.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.j6.product_management.BomApis;
import com.zeroone.star.project.j6.product_management.dto.BomDTO;
import com.zeroone.star.project.j6.product_management.query.BomQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 产品BOM关系表 前端控制器
 * </p>
 *
 * @author panda
 * @since 2024-05-27
 */
@RestController
@RequestMapping("/productManagement/md-product-bom")
public class MdProductBomController implements BomApis {
    @GetMapping("/list")
    @ApiOperation(value = "查询bom列表")
    @Override
    public JsonVO<Page<BomDTO>> queryBomList(BomQuery query){
        return null;
    }
    @GetMapping("/add")
    @ApiOperation(value = "新增bom数据")
    @Override
    public JsonVO<Long> addBom(BomDTO dto) {
        return null;
    }
    @GetMapping("/update")
    @ApiOperation(value = "修改bom数据")
    @Override
    public JsonVO<Long> updateBom(BomDTO dto) {
        return null;
    }
    @GetMapping("/delete")
    @ApiOperation(value = "删除bom数据")
    @Override
    public JsonVO<Long> deleteBOM(List<Long> bomIds) {
        return null;
    }
}


package com.zeroone.star.productManagement.controller;

import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.productManagement.entity.ProductSop;
import com.zeroone.star.productManagement.service.IProductSopService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.product_management.ProductSopApis;
import com.zeroone.star.project.j6.product_management.dto.ProductSopDTO;
import com.zeroone.star.project.j6.product_management.query.ProductSopQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 描述：产品SOP控制器
 * </p>
 * @version 1.0.0
 */
@Api("产品SOP控制器")
@RestController
@RequestMapping("/api/md/sop")
public class ProductSopController  implements ProductSopApis {

    @Autowired
    private IProductSopService ProductSopService;

    @Override
    @GetMapping("/list")
    public JsonVO<PageDTO<ProductSopDTO>> queryAll(ProductSopQuery query) {
        return JsonVO.success(ProductSopService.selectProductSopPage(query));
    }

    @Override
    @GetMapping("/{id}")
    public JsonVO<ProductSopDTO> queryById(@PathVariable Long id) {
        ProductSopDTO dto = ProductSopService.selectProductSopById(id);
        return JsonVO.success(dto);
    }

    @Override
    @PostMapping
    public JsonVO<String> add(@RequestBody ProductSopDTO dto) {
        ProductSopService.insertProductSop(dto);
        return JsonVO.success("新增成功");
    }

    @Override
    @PutMapping
    public JsonVO<String> edit(@RequestBody ProductSopDTO dto) {
        ProductSopService.updateProductSop(dto);
        return JsonVO.success("修改成功");
    }

    @Override
    @DeleteMapping("/{ids}")
    public JsonVO<String> remove(@PathVariable Long[] ids) {
        ProductSopService.deleteProductSopByIds(ids);
        return JsonVO.success("删除成功");
    }

    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductSopQuery query) {


    }
}


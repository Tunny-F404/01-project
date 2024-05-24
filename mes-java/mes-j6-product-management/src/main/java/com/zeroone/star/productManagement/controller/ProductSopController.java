package com.zeroone.star.productManagement.controller;

import com.zeroone.star.productManagement.service.IProductSopService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.product_management.ProductSopApis;
import com.zeroone.star.project.j6.product_management.dto.ProductSopDTO;
import com.zeroone.star.project.j6.product_management.query.ProductSopQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 描述：产品SOP控制器
 * </p>
 *
 * @version 1.0.0
 */
@Api(tags = "产品sop相关接口")
@RestController
@RequestMapping("/product-management/sop")
public class ProductSopController implements ProductSopApis {

    @Autowired
    private IProductSopService ProductSopService;

    @Override
    @ApiOperation(value = "查询sop列表")
    @GetMapping("/list")
    public JsonVO<PageDTO<ProductSopDTO>> queryAll(ProductSopQuery query) {
        return JsonVO.success(ProductSopService.selectProductSopPage(query));
    }

    @Override
    @ApiOperation(value = "查询sop")
    @GetMapping("/{id}")
    public JsonVO<ProductSopDTO> queryById(@PathVariable Long id) {
        ProductSopDTO dto = ProductSopService.selectProductSopById(id);
        return JsonVO.success(dto);
    }

    @Override
    @ApiOperation(value = "新增sop数据")
    @PostMapping
    public JsonVO<String> add(@RequestBody ProductSopDTO dto) {
        ProductSopService.insertProductSop(dto);
        return JsonVO.success("新增成功");
    }

    @Override
    @ApiOperation(value = "修改sop数据")
    @PutMapping
    public JsonVO<String> edit(@RequestBody ProductSopDTO dto) {
        ProductSopService.updateProductSop(dto);
        return JsonVO.success("修改成功");
    }

    @Override
    @ApiOperation(value = "删除sop数据")
    @DeleteMapping("/{ids}")
    public JsonVO<String> remove(@PathVariable Long[] ids) {
        ProductSopService.deleteProductSopByIds(ids);
        return JsonVO.success("删除成功");
    }

    @Override
    @ApiOperation(value = "上传SOP文件")
    @PostMapping("/uploadFile")
    public JsonVO<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String sop_url = ProductSopService.uploadFile(file);
        if (sop_url != null) {
            ProductSopDTO dto = new ProductSopDTO();
            dto.setSopUrl(sop_url);
            return JsonVO.success(sop_url);
        } else {
            return JsonVO.fail("文件上传失败");
        }
    }


}


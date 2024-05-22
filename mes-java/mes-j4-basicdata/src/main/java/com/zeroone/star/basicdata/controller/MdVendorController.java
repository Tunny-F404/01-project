package com.zeroone.star.basicdata.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.basicdata.entity.MdVendor;
import com.zeroone.star.basicdata.service.IMdVendorService;
import com.zeroone.star.project.dto.j4.basicdata.VendorDTO;
import com.zeroone.star.project.dto.j4.basicdata.VendorExcelSelectDTO;
import com.zeroone.star.project.j4.basicdata.SupplierApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 供应商相关操作 前端控制器
 * </p>
 *
 * @author 本鼠
 * @since 2024-05-21
 */

@RestController
@Api(tags = "供应商相关操作")
@RequestMapping("/basicdata/md-vendor")
@Validated
public class MdVendorController implements SupplierApis {

    @Resource
    private IMdVendorService iMdVendorService;
    /*
     * 导出供应商
     * */
    @ApiOperation(value = "导出供应商")
    @GetMapping(value = "download-vendor", produces = "application/octet-stream")
    public ResponseEntity<byte[]> exportVendor(VendorExcelSelectDTO vendorExcelSelectDTO) {
        ResponseEntity<byte[]> responseEntity = iMdVendorService.exportVendor(vendorExcelSelectDTO);
        return responseEntity;
    }

    @ApiOperation(value = "添加供应商")
    @PostMapping("add-vendor")
    public JsonVO<Integer> addVendor(@RequestBody VendorDTO data)
    {
        return JsonVO.success(iMdVendorService.addVendor(data));
    }

    /**
     * 供应商分页查询
     * */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public JsonVO<Page> page(int page, int pageSize) {

        //分页构造器
        Page<MdVendor> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<MdVendor> lqw = new LambdaQueryWrapper<>();
        lqw.orderByAsc(MdVendor::getVendorId);
        iMdVendorService.page(pageInfo, lqw);
        return JsonVO.success(pageInfo);
    }

    /**
     * 查询供应商详情
     * */
    @GetMapping("/{VendorId}")
    @ApiOperation("查询供应商详情")
    public JsonVO<MdVendor> get(@PathVariable Long VendorId){
        return JsonVO.success(iMdVendorService.getByVendorId(VendorId));
    }

    @DeleteMapping
    @ApiOperation("批量删除供应商")
    public JsonVO delete(@RequestParam List<Integer> ids){
        iMdVendorService.deleteVendors(ids);
        return JsonVO.success("操作成功");
    }
}

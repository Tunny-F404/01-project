package com.zeroone.star.basicdata.controller;

import com.zeroone.star.basicdata.service.IMdVendorService;
import com.zeroone.star.project.dto.j4.basicdata.VendorDTO;
import com.zeroone.star.project.dto.j4.basicdata.VendorExcelSelectDTO;
import com.zeroone.star.project.j4.basicdata.SupplierApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public JsonVO<Integer> addVendor(VendorDTO data)
    {
        return JsonVO.success(iMdVendorService.addVendor(data));
    }
}

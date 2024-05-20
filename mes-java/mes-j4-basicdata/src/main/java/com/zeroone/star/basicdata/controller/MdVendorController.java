package com.zeroone.star.basicdata.controller;


import com.zeroone.star.basicdata.service.IMdVendorService;
import com.zeroone.star.project.dto.j4.basicdata.VendorDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 供应商表 前端控制器
 * </p>
 *
 * @author zjx
 * @since 2024-05-20
 */
@RestController
@RequestMapping("/basicdata/md-vendor")
public class MdVendorController {
    @Resource
    private IMdVendorService mdVendorService;

    @ApiOperation(value = "添加供应商")
    @PostMapping("add-vendor")
    public JsonVO<Integer> addVendor(VendorDTO data)
    {
        return JsonVO.success(mdVendorService.addVendor(data));
    }

}


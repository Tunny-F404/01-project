package com.zeroone.star.basicdata.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.basicdata.entity.mdVendor;
import com.zeroone.star.basicdata.service.VendorService;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("prod-api/mes/md/client")
@RestController
@Api(tags = "供应商相关接口")
public class VendorController {
    @Autowired
    VendorService vendorService;

    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public JsonVO<Page> page(int page, int pageSize) {

        //分页构造器
        Page<mdVendor> pageInfo = new Page<>();
        LambdaQueryWrapper<mdVendor> lqw = new LambdaQueryWrapper<>();
        lqw.orderByAsc(mdVendor::getVendorId);
        vendorService.page(pageInfo, lqw);
        return JsonVO.success(pageInfo);
    }


}

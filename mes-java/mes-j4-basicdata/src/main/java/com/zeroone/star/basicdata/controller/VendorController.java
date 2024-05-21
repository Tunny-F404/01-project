package com.zeroone.star.basicdata.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.basicdata.entity.MdVendor;
import com.zeroone.star.basicdata.service.VendorService;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/prod-api/mes/md/vendor")
@RestController
@Api(tags = "供应商相关接口")
public class VendorController {
    @Autowired
    VendorService vendorService;

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
        vendorService.page(pageInfo, lqw);
        return JsonVO.success(pageInfo);
    }

    /**
     * 查询供应商详情
     * */
    @GetMapping("/{VendorId}")
    @ApiOperation("查询供应商详情")
    public JsonVO<MdVendor> get(@PathVariable Long VendorId){
        return JsonVO.success(vendorService.getByVendorId(VendorId));
    }

    @DeleteMapping
    @ApiOperation("批量删除供应商")
    public JsonVO delete(@RequestParam List<Integer> ids){
        vendorService.deleteVendors(ids);
        return JsonVO.success("操作成功");
    }
}

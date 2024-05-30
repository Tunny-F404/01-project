package com.zeroone.star.shopsettings.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.AddShopSettingsDTO;
import com.zeroone.star.project.j5.dto.shopsettings.ModifyShopSettingsDTO;
import com.zeroone.star.project.j5.dto.shopsettings.ShopSettingsDTO;
import com.zeroone.star.project.j5.query.shopsettings.ShopSettingsQuery;
import com.zeroone.star.project.j5.shopsettings.ShopSettingsApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.shopsettings.service.IMdWorkshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "车间管理")
@RestController
@RequestMapping("ShopSettings")
public class ShopSettingsController implements ShopSettingsApis {
    
    @Resource
    IMdWorkshopService mdWorkshopService;

    @Override
    @ApiOperation("获取车间管理列表（条件+分页）")
    @GetMapping("/query-list")
    public JsonVO<PageDTO<ShopSettingsDTO>> queryWorkshopList(@Validated ShopSettingsQuery shopSettingsQuery) {
        PageDTO<ShopSettingsDTO> pageDTO = mdWorkshopService.queryWorkshopList(shopSettingsQuery);
        if(pageDTO != null){
            return JsonVO.success(pageDTO);
        }
        return JsonVO.fail(null);
    }

    @Override
    @ApiOperation("获取车间详情")
    @GetMapping("/query/{workShopId}")
    public JsonVO<ShopSettingsDTO> queryWorkshopInfo(@PathVariable Long workShopId) {
        ShopSettingsDTO getShopSettingsDTO = mdWorkshopService.queryWorkshopInfo(workShopId);
        return getShopSettingsDTO != null ? JsonVO.success(getShopSettingsDTO) : JsonVO.fail(null);
    }

    @Override
    @ApiOperation("获取车间名称列表")
    @GetMapping("/query-name-list")
    public JsonVO<List<String>> queryWorkshopNameList() {
        List<String> workshopNameList = mdWorkshopService.queryWorkshopNameList();
        return !workshopNameList.isEmpty() ? JsonVO.success(workshopNameList) : JsonVO.fail(null);
    }

    @Override
    @ApiOperation("更新车间")
    @PutMapping("/modify")
    public JsonVO<Integer> modifyWorkshop(ModifyShopSettingsDTO modifyShopSettingsDTO) {
        return null;
    }

    @Override
    @ApiOperation("添加车间")
    @PutMapping("/add")
    public JsonVO<Integer> addWorkshop(AddShopSettingsDTO addShopSettingsDTO) {
        System.out.println("apple");
        return null;
    }

    @Override
    @ApiOperation("删除车间（支持批量删除）")
    @DeleteMapping("/delete/{workshopIds}")
    public JsonVO<Integer> removeWorkshop(List<Long> workshopIds) {
        return null;
    }
}

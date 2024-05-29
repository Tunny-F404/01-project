package com.zeroone.star.shopsettings.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.project.j5.query.shopsettings.ShopSettingsQuery;
import com.zeroone.star.project.j5.shopsettings.ShopSettingsApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.shopsettings.service.ShopsettingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "车间管理")
@RestController
@RequestMapping("ShopSettings")
public class ShopSettingsController implements ShopSettingsApis {
    @Autowired(required = false)
    ShopsettingsService shopsettingsService;


    @Override
    @ApiOperation("获取车间管理列表（条件+分页）")
    @GetMapping("/query-list")
    public JsonVO<PageDTO<GetShopSettingsDTO>> getShopSettingsList(ShopSettingsQuery shopSettingsQuery) {
        PageDTO<GetShopSettingsDTO> pageDTO = shopsettingsService.getShopSettingsList(shopSettingsQuery);
        if(pageDTO != null){
            return JsonVO.success(pageDTO);
        }
        return JsonVO.fail(null);
    }

    @Override
    @ApiOperation("获取车间详情")
    @GetMapping("/query-id")
    public JsonVO<GetShopSettingsDTO> getShopSettingsInfoByWorkShopId(Long workShopId) {
        GetShopSettingsDTO getShopSettingsDTO = shopsettingsService.getShopSettingsInfoByWorkShopId(workShopId);
        return getShopSettingsDTO != null ? JsonVO.success(getShopSettingsDTO) : JsonVO.fail(null);
    }

    @Override
    @ApiOperation("获取车间名称列表")
    @GetMapping("/query-name-list")
    public JsonVO<List<String>> getShopSettingNameList() {
        List<String> shopSettingsNameList = shopsettingsService.getShopSettingNameList();
        return shopSettingsNameList.size() > 0 ? JsonVO.success(shopSettingsNameList) : JsonVO.fail(null);
    }




    /**
     * 更新车间信息
     *
     * @param shopsettingsDTO
     * @return
     */
    @Override
    @PutMapping("/update-shopsetting")
    @ApiOperation("更新车间信息")
    public JsonVO<Integer> updateShopSeetingController(
            @ApiParam("车间DTO")@RequestBody GetShopSettingsDTO shopsettingsDTO) {
        shopsettingsService.Update(shopsettingsDTO);
        return null;
    }
    /**
     * 新增车间信息
     *
     * @param shopsettingsDTO
     * @return
     */
    @PutMapping("/sava-shopsetting")
    @Override
    @ApiOperation("新增车间信息")
    public JsonVO<Integer> saveShopSeetingController(
            @ApiParam("车间DTO")@RequestBody GetShopSettingsDTO shopsettingsDTO) {
        return null;
    }
    /**
     * 删除或批量删除车间信息
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/delete-shopsettings")
    @Override
    @ApiOperation("删除或批量删除车间信息")
    public JsonVO<Integer> deleteShopSeetingController(
            @ApiParam("车间id")@RequestParam List<Long> ids) {
        return null;
    }



}

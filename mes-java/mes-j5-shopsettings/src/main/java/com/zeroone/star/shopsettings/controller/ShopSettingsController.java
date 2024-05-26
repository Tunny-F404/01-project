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
    /**
     * 获取车间管理列表（条件+分页）
     * @param ShopSettingscondition
     * @return
     */
    @GetMapping("/query-by")
    @Override
    @ApiOperation("获取车间管理列表（条件+分页）")
    public JsonVO<PageDTO<GetShopSettingsDTO>> getShopSeetingController(
            @ApiParam("查询条件") @RequestBody ShopSettingsQuery ShopSettingscondition) {


        return null;
    }
    /**
     * 获取车间详情
     * @param GetShopSettingsDTO
     * @return
     */
    @Override
    @GetMapping("/get-shopsetting")
    @ApiOperation("获取车间详情")
    public JsonVO<GetShopSettingsDTO> getShopSeetingALLController(
            @ApiParam("车间DTO")@RequestBody GetShopSettingsDTO GetShopSettingsDTO) {

        return null;
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
    /**
     * 获取车间名称列表
     *
     * @param shopsettingsDTO
     * @return
     */
    @GetMapping("/get-shopsettings-name")
    @Override
    @ApiOperation("获取车间名称列表")
    public JsonVO<List<String>> getShopSeetingNameController(
            @ApiParam("车间DTO")@RequestBody GetShopSettingsDTO shopsettingsDTO) {
        return null;
    }


}

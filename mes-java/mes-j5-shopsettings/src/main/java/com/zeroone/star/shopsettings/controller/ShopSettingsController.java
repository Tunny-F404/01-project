package com.zeroone.star.shopsettings.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.project.j5.query.shopsettings.ShopSettingsQuery;
import com.zeroone.star.project.j5.shopsettings.ShopSettingsApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.shopsettings.service.ShopsettingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("getSTQuery")
    @Override
    @ApiOperation("获取车间管理列表（条件+分页）")
    public JsonVO<PageDTO<GetShopSettingsDTO>> getShopSeetingController(@RequestBody ShopSettingsQuery ShopSettingscondition) {


        return null;
    }
    /**
     * 获取车间名称列表
     * @param GetShopSettingsDTO
     * @return
     */
    @Override
    @GetMapping("getSTAll")
    @ApiOperation("获取车间名称列表")
    public JsonVO<GetShopSettingsDTO> getShopSeetingALLController(@RequestBody GetShopSettingsDTO GetShopSettingsDTO) {

        return null;
    }
    /**
     * 更新车间信息
     * @param shopsettingsDTO
     * @return
     */
    @Override
    @PutMapping("updateST")
    @ApiOperation("更新车间信息")
    public JsonVO<GetShopSettingsDTO> updateShopSeetingController(@RequestBody GetShopSettingsDTO shopsettingsDTO) {
        shopsettingsService.Update(shopsettingsDTO);
        return null;
    }
    /**
     * 新增车间信息
     * @param shopsettingsDTO
     * @return
     */
    @PutMapping("savaST")
    @Override
    @ApiOperation("新增车间信息")
    public JsonVO<GetShopSettingsDTO> saveShopSeetingController(@RequestBody GetShopSettingsDTO shopsettingsDTO) {
        return null;
    }
    /**
     * 删除或批量删除车间信息
     * @param shopsettingsDTO
     * @return
     */
    @DeleteMapping("deleteST")
    @Override
    @ApiOperation("删除或批量删除车间信息")
    public JsonVO<GetShopSettingsDTO> deleteShopSeetingController(@RequestBody GetShopSettingsDTO shopsettingsDTO) {
        return null;
    }
    /**
     * 获取车间名称列表
     * @param shopsettingsDTO
     * @return
     */
    @GetMapping("getSTName")
    @Override
    @ApiOperation("获取车间名称列表")
    public JsonVO<GetShopSettingsDTO> getShopSeetingNameController(@RequestBody GetShopSettingsDTO shopsettingsDTO) {
        return null;
    }


}

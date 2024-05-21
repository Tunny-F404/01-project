package com.zeroone.star.shopsettings.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.project.j5.query.ShopSettingsQuery;
import com.zeroone.star.project.j5.shopsettings.ShopSettingsApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.shopsettings.service.ShopsettingsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "车间管理")
@RestController
@RequestMapping("ShopSettings")
public class ShopSettingsController implements ShopSettingsApis {

    @Autowired
    private ShopsettingsService shopsettingsService;
    @Override
    public JsonVO<PageDTO<GetShopSettingsDTO>> getShopSeetingController(GetShopSettingsDTO shopsettingsDTO) {
        return JsonVO.success();
    }

    @Override
    public JsonVO<PageDTO<GetShopSettingsDTO>> queryAll(ShopSettingsQuery ShopSettingscondition) {
        return null;
    }

    @Override
    public JsonVO<GetShopSettingsDTO> saveOrUpdateShopSeetingController(GetShopSettingsDTO shopsettingsDTO) {
        return null;
    }

    @Override
    public JsonVO<GetShopSettingsDTO> deleteShopSeetingController(GetShopSettingsDTO shopsettingsDTO) {
        Long ids = shopsettingsDTO.getWorkshop_id();
        return JsonVO.success(shopsettingsService.removeById(ids));
    }

    @Override
    public JsonVO<GetShopSettingsDTO> getShopSeetingNameController(GetShopSettingsDTO shopsettingsDTO) {
        return null;
    }
}

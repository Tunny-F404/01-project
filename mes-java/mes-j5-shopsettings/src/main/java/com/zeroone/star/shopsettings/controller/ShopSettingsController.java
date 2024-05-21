package com.zeroone.star.shopsettings.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.project.j5.query.ShopSettingsQuery;
import com.zeroone.star.project.j5.shopsettings.ShopSettingsApis;
import com.zeroone.star.project.vo.JsonVO;

public class ShopSettingsController implements ShopSettingsApis {
    @Override
    public JsonVO<PageDTO<GetShopSettingsDTO>> getShopSeetingController(GetShopSettingsDTO shopsettingsDTO) {
        return null;
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
        return null;
    }

    @Override
    public JsonVO<GetShopSettingsDTO> getShopSeetingNameController(GetShopSettingsDTO shopsettingsDTO) {
        return null;
    }
}

package com.zeroone.star.shopsettings.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.project.j5.query.shopsettings.ShopSettingsQuery;
import com.zeroone.star.shopsettings.entity.WorkShop;

import java.util.List;

public interface ShopsettingsService extends IService<WorkShop> {

    void Update(GetShopSettingsDTO shopsettingsDTO);

    PageDTO<GetShopSettingsDTO> getShopSettingsList(ShopSettingsQuery shopSettingsQuery);

    GetShopSettingsDTO getShopSettingsInfoByWorkShopId(Long workShopId);

    List<String> getShopSettingNameList();
}

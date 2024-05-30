package com.zeroone.star.shopsettings.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.shopsettings.entity.WorkShop;

import java.util.List;

public interface ShopsettingsService extends IService<WorkShop> {

    void Update(GetShopSettingsDTO shopsettingsDTO);

    int removeshopsettings(List<Long> ids);
}

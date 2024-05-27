package com.zeroone.star.shopsettings.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.shopsettings.entity.WorkShop;
import com.zeroone.star.shopsettings.mapper.WorkShopMapper;
import com.zeroone.star.shopsettings.service.ShopsettingsService;

public class ShopsettingsImpl extends ServiceImpl<WorkShopMapper, WorkShop> implements ShopsettingsService {

    @Override
    public void Update(GetShopSettingsDTO shopsettingsDTO) {

    }
}

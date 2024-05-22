package com.zeroone.star.shopsettings.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.project.j5.query.shopsettings.ShopSettingsQuery;
import com.zeroone.star.project.j5.shopsettings.ShopSettingsApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述：班组设置控制器
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author xiangjun
 * @version 1.0.0
 */
@Api(tags = "车间管理接口")
@RestController
@RequestMapping("base-data/shop-settings")
@Validated
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

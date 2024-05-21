package com.zeroone.star.project.j5.shopsettings;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.project.j5.query.ShopSettingsQuery;
import com.zeroone.star.project.vo.JsonVO;

/**
 * <p>
 * 描述：车间设置接口
 * @author 翔君
 * @version 1.0.0
 */
public interface ShopSettingsApis {
    //获取车间管理列表（条件+分页）
    /**
     * 获取车间管理列表（条件+分页）
     * @param shopsettingsDTO
     * @return
     */
    JsonVO<PageDTO<GetShopSettingsDTO>> getShopSeetingController(GetShopSettingsDTO shopsettingsDTO);

    /**
     * 通过车间id或车间名称查询数据
     * @param ShopSettingscondition
     * @return
     */
    JsonVO<PageDTO<GetShopSettingsDTO>> queryAll(ShopSettingsQuery ShopSettingscondition);
    /**
     * 新增或更新车间信息
     * @param shopsettingsDTO
     * @return
     */
    JsonVO<GetShopSettingsDTO> saveOrUpdateShopSeetingController(GetShopSettingsDTO shopsettingsDTO);
    /**
     * 删除或批量删除车间信息
     * @param shopsettingsDTO
     * @return
     */
    JsonVO<GetShopSettingsDTO> deleteShopSeetingController(GetShopSettingsDTO shopsettingsDTO);
    /**
     * 获取车间详情
     * @param shopsettingsDTO
     * @return
     */
    JsonVO<GetShopSettingsDTO> getShopSeetingNameController(GetShopSettingsDTO shopsettingsDTO);

}

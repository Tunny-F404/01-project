package com.zeroone.star.project.j5.shopsettings;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.project.j5.query.shopsettings.ShopSettingsQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

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
     * @param ShopSettingscondition
     * @return
     */
    JsonVO<PageDTO<GetShopSettingsDTO>> getShopSeetingController(ShopSettingsQuery ShopSettingscondition);
    /**
     * 获取车间详情
     * @param GetShopSettingsDTO
     * @return
     */
    JsonVO<GetShopSettingsDTO> getShopSeetingALLController(GetShopSettingsDTO GetShopSettingsDTO);
    /**
     * 更新车间信息
     * @param shopsettingsDTO
     * @return
     */
    JsonVO<Integer> updateShopSeetingController(GetShopSettingsDTO shopsettingsDTO);
    /**
     * 新增车间信息
     * @param shopsettingsDTO
     * @return
     */
    JsonVO<Integer> saveShopSeetingController(GetShopSettingsDTO shopsettingsDTO);
    /**
     * 删除或批量删除车间信息
     * @param ids
     * @return
     */
    JsonVO<Integer> deleteShopSeetingController(List<Long> ids );
    /**
     * 获取车间名称列表
     * @param shopsettingsDTO
     * @return
     */
    JsonVO<GetShopSettingsDTO> getShopSeetingNameController(GetShopSettingsDTO shopsettingsDTO);

}

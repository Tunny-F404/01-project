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

    /**
     * 获取车间管理列表（条件+分页）
     * @param ShopSettingsCondition 查询条件
     * @return  车间列表
     */
    JsonVO<PageDTO<GetShopSettingsDTO>> getShopSettingsList(ShopSettingsQuery ShopSettingsCondition);

    /**
     * 获取车间详情
     * @param workShopId 车间号
     * @return 车间详细信息
     */
    JsonVO<GetShopSettingsDTO> getShopSettingsInfoByWorkShopId(Long workShopId);

    /**
     * 获取车间名称列表
     * @return 名称列表
     */
    JsonVO<List<String>> getShopSettingNameList();

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


}

package com.zeroone.star.shopsettings.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.shopsettings.entity.WorkShop;
import com.zeroone.star.shopsettings.mapper.WorkShopMapper;
import com.zeroone.star.shopsettings.service.ShopsettingsService;

import java.util.List;

public class ShopsettingsImpl extends ServiceImpl<WorkShopMapper, WorkShop> implements ShopsettingsService {


    @Override
    public void Update(GetShopSettingsDTO shopsettingsDTO) {

    }

    @Override
    public int removeshopsettings(List<Long> ids) {
        int totalDeleted = 0;
        for(Long workshopId : ids){
            int deleteRow = baseMapper.delete(new QueryWrapper<WorkShop>().eq("workshop_id", workshopId));
            if(deleteRow < 1){
                throw new RuntimeException("删除失败");
            }
            totalDeleted += deleteRow;
        }
        return totalDeleted;
    }

    @Override
    public int addShiftPlan(GetShopSettingsDTO shopsettingsDTO) {
        return 0;
    }

    @Override
    public int modifyShopSettings(GetShopSettingsDTO shopsettingsDTO) {
        //修改数据
        WorkShop workShop = msCalShiftPlanMapper.modifyShiftPlanToShiftPlan(shiftPlanModifyDto);
        UpdateWrapper<WorkShop> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("workshop_id", workShop.getWorkshop_id());
        //返回修改的行数
        return baseMapper.update(workShop, updateWrapper);
    }

}

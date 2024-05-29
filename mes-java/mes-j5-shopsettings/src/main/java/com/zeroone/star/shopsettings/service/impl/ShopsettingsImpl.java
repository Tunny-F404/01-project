package com.zeroone.star.shopsettings.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.GetShopSettingsDTO;
import com.zeroone.star.project.j5.query.shopsettings.ShopSettingsQuery;
import com.zeroone.star.shopsettings.entity.WorkShop;
import com.zeroone.star.shopsettings.mapper.WorkShopMapper;
import com.zeroone.star.shopsettings.service.ShopsettingsService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Mapper(componentModel = "spring")
interface msWorkShopMapper{
    /**
     * 将车间do转车间dto
     * @param workShop 车间do
     * @return  车间dto
     */
    GetShopSettingsDTO workShopToGetShopSettingsDTO(WorkShop workShop);
}

@Service
public class ShopsettingsImpl extends ServiceImpl<WorkShopMapper, WorkShop> implements ShopsettingsService {

    @Resource
    msWorkShopMapper msWorkShopMapper;

    @Override
    public void Update(GetShopSettingsDTO shopsettingsDTO) {

    }

    //获取车间数据列表
    @Override
    public PageDTO<GetShopSettingsDTO> getShopSettingsList(ShopSettingsQuery shopSettingsQuery) {
        Page<WorkShop> workShopPage = new Page<>(shopSettingsQuery.getPageIndex(),shopSettingsQuery.getPageSize());
        QueryWrapper<WorkShop> wrapper = new QueryWrapper<WorkShop>()
                .eq("workshop_code", shopSettingsQuery.getWorkshop_code())
                .eq("work_name", shopSettingsQuery.getWorkshop_name());
        Page<WorkShop> result = baseMapper.selectPage(workShopPage, wrapper);
        return PageDTO.create(result, msWorkShopMapper::workShopToGetShopSettingsDTO);
    }

    //获取车间详细信息
    @Override
    public GetShopSettingsDTO getShopSettingsInfoByWorkShopId(Long workShopId) {
        System.out.println(workShopId);
        WorkShop workShop = baseMapper.selectById(workShopId);
        return msWorkShopMapper.workShopToGetShopSettingsDTO(workShop);
    }

    //获取车间名称列表
    @Override
    public List<String> getShopSettingNameList() {
        List<String> shopSettingNameList = baseMapper.queryWorkShopNameList();
        System.out.println(shopSettingNameList);
        return shopSettingNameList;
    }
}

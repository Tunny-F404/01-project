package com.zeroone.star.shopsettings.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.shopsettings.ShopSettingsDTO;
import com.zeroone.star.project.j5.query.shopsettings.ShopSettingsQuery;
import com.zeroone.star.shopsettings.entity.MdWorkshop;
import com.zeroone.star.shopsettings.mapper.MdWorkshopMapper;
import com.zeroone.star.shopsettings.service.IMdWorkshopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 车间表 服务实现类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-29
 */
@Mapper(componentModel = "spring")
interface msMdWorkshopMapper{
    /**
     * 将车间do转车间dto
     * @param mdWorkshop 车间do
     * @return  车间dto
     */
    ShopSettingsDTO mdWorkshopToShopSettingsDTO(MdWorkshop mdWorkshop);
}

@Service
public class MdWorkshopServiceImpl extends ServiceImpl<MdWorkshopMapper, MdWorkshop> implements IMdWorkshopService {
    @Resource
    msMdWorkshopMapper msMdWorkshopMapper;

//    @Override
//    public void Update(GetShopSettingsDTO shopsettingsDTO) {
//
//    }
    //获取车间数据列表
    @Override
    public PageDTO<ShopSettingsDTO> queryWorkshopList(ShopSettingsQuery shopSettingsQuery) {
        Page<MdWorkshop> mdWorkshopPage = new Page<>(shopSettingsQuery.getPageIndex(),shopSettingsQuery.getPageSize());
        QueryWrapper<MdWorkshop> wrapper = new QueryWrapper<MdWorkshop>()
                .eq("MdWorkshop_code", shopSettingsQuery.getWorkshopCode())
                .eq("work_name", shopSettingsQuery.getWorkshopName());
        Page<MdWorkshop> result = baseMapper.selectPage(mdWorkshopPage, wrapper);
        return PageDTO.create(result, msMdWorkshopMapper::mdWorkshopToShopSettingsDTO);
    }

    //获取车间详细信息
    @Override
    public ShopSettingsDTO queryWorkshopInfo(Long workShopId) {
        System.out.println(workShopId);
        MdWorkshop MdWorkshop = baseMapper.selectById(workShopId);
        return msMdWorkshopMapper.mdWorkshopToShopSettingsDTO(MdWorkshop);
    }

    //获取车间名称列表
    @Override
    public List<String> queryWorkshopNameList() {
        List<String> shopSettingNameList = baseMapper.queryMdWorkshopNameList();
        System.out.println(shopSettingNameList);
        return shopSettingNameList;
    }
}

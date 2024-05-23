package com.zeroone.star.sysmanagement.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;
import com.zeroone.star.sysmanagement.entity.Menu;
import com.zeroone.star.sysmanagement.mapper.MenuMapper;
import org.mapstruct.Mapper;
import com.zeroone.star.sysmanagement.service.MenuService;


import javax.annotation.Resource;


public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    MsMenuMapper msMenuMapper;

    @Override
    public int addMenu(MenuDTO menuDTO) {
        Menu menu = msMenuMapper.menuToMenuDTO(menuDTO);
        return baseMapper.insert(menu);
    }
    @Override
    public int modifyMenu(MenuDTO menuDTO) {
        Menu menu = msMenuMapper.menuToMenuDTO(menuDTO);
        menu.setUpdate_time(String.valueOf(DateTime.now()));
        return baseMapper.updateById(menu);
    }

    @Override
    public int removeMenu(int menu_id) {
        Menu menu = baseMapper.selectById(menu_id);
        baseMapper.deleteById(menu);
        return menu_id;
    }


}

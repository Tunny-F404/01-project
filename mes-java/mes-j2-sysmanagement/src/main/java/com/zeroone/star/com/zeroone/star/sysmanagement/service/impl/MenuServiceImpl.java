package com.zeroone.star.com.zeroone.star.sysmanagement.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.com.zeroone.star.sysmanagement.entity.SysMenuDO;
import com.zeroone.star.com.zeroone.star.sysmanagement.mapper.SysMenuMapper;
import com.zeroone.star.com.zeroone.star.sysmanagement.service.MenuService;
import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;


import javax.annotation.Resource;
import java.time.LocalDateTime;


public class MenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuDO> implements MenuService {

    @Resource
    MsMenuMapper msMenuMapper;

    @Override
    public int addMenu(MenuDTO menuDTO) {
        SysMenuDO menu = msMenuMapper.menuToMenuDTO(menuDTO);
        menu.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(menu);
    }
    @Override
    public int modifyMenu(MenuDTO menuDTO) {
        SysMenuDO menu = msMenuMapper.menuToMenuDTO(menuDTO);
        menu.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(menu);
    }

    @Override
    public int removeMenu(int menu_id) {
        SysMenuDO menu = baseMapper.selectById(menu_id);
        menu.setUpdateTime(LocalDateTime.now());
        return menu_id;
    }


}

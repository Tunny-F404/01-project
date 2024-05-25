package com.zeroone.star.sysmanagement.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;
import com.zeroone.star.sysmanagement.entity.SysMenuDO;


public interface MenuService extends IService<SysMenuDO> {

    // 新增菜单
    int addMenu(MenuDTO menuDTO);

    // 删除菜单
    int removeMenu(int menu_id);

    // 修改菜单
    int modifyMenu(MenuDTO menuDTO);
}

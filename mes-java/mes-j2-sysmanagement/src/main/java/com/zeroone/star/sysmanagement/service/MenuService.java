package com.zeroone.star.sysmanagement.service;

import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;
import com.zeroone.star.project.j2.sysmanagement.query.menu.MenuQuery;
import com.zeroone.star.sysmanagement.dao.MenuDao;

import javax.annotation.Resource;

public class MenuService {
    @Resource
    private MenuDao menuDao;
    public MenuQuery menu_id;

    public void addMenu(MenuDTO menuDTO) {
        menuDao.addMenu(menuDTO);
    }

    public void modifyMenu(MenuDTO menuDTO) {
        menuDao.modifyMenu(menuDTO);
    }

    public void removeMenu(MenuQuery menu_id) {
        menuDao.removeMenu(menu_id);
    }
}

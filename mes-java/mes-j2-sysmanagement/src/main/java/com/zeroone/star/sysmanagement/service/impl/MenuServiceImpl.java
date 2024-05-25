package com.zeroone.star.sysmanagement.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j2.sysmanagement.vo.ResourceDetailsVO;
import com.zeroone.star.project.j2.sysmanagement.vo.ResourceTreeVO;
import com.zeroone.star.project.j2.sysmanagement.vo.ResourceVO;
import com.zeroone.star.sysmanagement.entity.SysMenuDO;
import com.zeroone.star.sysmanagement.mapper.SysMenuMapper;
import com.zeroone.star.sysmanagement.service.MenuService;
import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class MenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuDO> implements MenuService {

    @Resource
    MsMenuMapper msMenuMapper;

    @Resource
    SysMenuMapper sysMenuMapper;

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

    @Override
    public List<ResourceTreeVO> getResourceNameTree() {
        return sysMenuMapper.getResourceNameTree();
    }

    @Override
    public List<ResourceVO> getResourceListByCondition(String menuName, Integer status) {
        return sysMenuMapper.getResourceListByCondition(menuName, status);
    }

    @Override
    public ResourceDetailsVO getResourceDetailsByMenuId(Integer menu_id) {
        return sysMenuMapper.getResourceDetailsByMenuId(menu_id);
    }
}

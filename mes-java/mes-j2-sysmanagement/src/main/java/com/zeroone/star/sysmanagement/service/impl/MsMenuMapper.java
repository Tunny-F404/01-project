package com.zeroone.star.sysmanagement.service.impl;

import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;
import com.zeroone.star.sysmanagement.entity.Menu;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MsMenuMapper {

    /**
     * 转换Menu转化为MenuDTO
     * @param menuDTO
     * @return
     * @throws
     * @since 1.0
     */
    Menu menuToMenuDTO(MenuDTO menuDTO);

}

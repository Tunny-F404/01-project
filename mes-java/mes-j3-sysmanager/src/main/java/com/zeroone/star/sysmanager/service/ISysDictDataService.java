package com.zeroone.star.sysmanager.service;

import com.zeroone.star.project.j3.vo.DictDataNameVO;
import com.zeroone.star.project.j3.dto.SysDictDataDTO;
import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.sysmanager.entity.SysDictData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
public interface ISysDictDataService extends IService<SysDictData> {

    List<DictDataNameVO> listDictDataNameByDictType(String dictType);

    Integer saveDictData(SysDictDataDTO sysDictDataDTO, UserDTO currentUser);

    Integer updateDictData(SysDictDataDTO sysDictDataDTO, UserDTO currentUser);
}

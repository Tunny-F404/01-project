package com.zeroone.star.sysmanager.service;

import com.zeroone.star.project.j3.dto.InsertDictTypeDTO;
import com.zeroone.star.project.j3.vo.DictTypeNameVO;
import com.zeroone.star.sysmanager.entity.SysDictType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
public interface ISysDictTypeService extends IService<SysDictType> {
    Long saveDictType(InsertDictTypeDTO dto);

    List<DictTypeNameVO> listDictTypeName();
}

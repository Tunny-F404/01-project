package com.zeroone.star.sysmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictTypeDetailDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictTypeListDTO;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanager.entity.SysDictType;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
public interface ISysDictTypeService extends IService<SysDictType> {

    public JsonVO<PageDTO<SysDictTypeListDTO>> listDictType(SysDictTypeQuery dictTypeQuery);

    public JsonVO<SysDictTypeDetailDTO> getDictType(Long dictId);
}

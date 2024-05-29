package com.zeroone.star.orgstructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.orgstructure.entity.RoleDo;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述：对Role表增删改
 *
 * @author 0xu0
 * @version 1.0.0
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleDo> {


}

package com.zeroone.star.customer.mapper;

import com.zeroone.star.customer.entity.MdClient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 客户表 Mapper 接口
 * </p>
 *
 * @author 小鱼
 * @since 2024-05-20
 */
@Mapper
public interface MdClientMapper extends BaseMapper<MdClient> {

}

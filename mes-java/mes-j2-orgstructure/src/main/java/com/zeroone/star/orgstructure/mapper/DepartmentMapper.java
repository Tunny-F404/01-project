package com.zeroone.star.orgstructure.mapper;

import com.zeroone.star.orgstructure.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.awt.*;
import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 宵夜
 * @since 2024-05-22
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    /**
     *
     * @param ids 部门名称
     * @return 返回列表
     */
    List<Department> selectByName(Integer ids);
    /**
     * 返回查询条件的实体(root)
     * @param name 部门名称
     * @return 返回列表
     */
    List<Department> selectByNameOne(String name);
}

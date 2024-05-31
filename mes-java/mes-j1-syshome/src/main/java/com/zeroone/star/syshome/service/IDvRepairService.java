package com.zeroone.star.syshome.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j1.syshome.dto.toDoEvent.ToDoEventDTO;
import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.syshome.entity.DvRepair;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.syshome.entity.vo.plan.PlanVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 设备维修单 服务类
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
public interface IDvRepairService extends IService<DvRepair> {

    PageDTO<ToDoEventDTO> selectToDoEvent(PageQuery pageQuery, String username);


}

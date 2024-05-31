package com.zeroone.star.syshome.service;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j1.syshome.dto.plan.PlanDTO;
import com.zeroone.star.project.j1.syshome.dto.toDoEvent.ToDoEventDTO;
import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.syshome.entity.ProFeedback;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.syshome.entity.vo.toDoEvent.ToDoEventVO;

import java.util.List;

/**
 * <p>
 * 生产报工记录表 服务类
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
public interface IProFeedbackService extends IService<ProFeedback> {
    List<ToDoEventDTO> listFeedback(String userName);
}

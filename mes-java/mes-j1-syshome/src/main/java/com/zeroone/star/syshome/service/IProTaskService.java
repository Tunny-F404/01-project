package com.zeroone.star.syshome.service;

import com.zeroone.star.project.j1.syshome.dto.toDoEvent.ToDoEventDTO;
import com.zeroone.star.syshome.entity.ProTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 生产任务表 服务类
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
public interface IProTaskService extends IService<ProTask> {

    List<ToDoEventDTO> listTask(String username);
}

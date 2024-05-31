package com.zeroone.star.syshome.service.impl;

import com.zeroone.star.project.j1.syshome.dto.toDoEvent.ToDoEventDTO;
import com.zeroone.star.syshome.entity.ProTask;
import com.zeroone.star.syshome.entity.vo.toDoEvent.ToDoEventVO;
import com.zeroone.star.syshome.mapper.DvRepairMapper;
import com.zeroone.star.syshome.mapper.ProTaskMapper;
import com.zeroone.star.syshome.service.IProTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 生产任务表 服务实现类
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
@Service
public class ProTaskServiceImpl extends ServiceImpl<ProTaskMapper, ProTask> implements IProTaskService {

    @Resource
    MsSysHomeMapper msSysHomeMapper;
    @Resource
    ProTaskMapper proTaskMapper;
    @Override
    public List<ToDoEventDTO> listTask(String userName) {
        List<ToDoEventVO> repairVOList = proTaskMapper.selectTask(userName);
        return repairVOList.stream().map(repairVO -> msSysHomeMapper.toDoEventVOTotoDoEventDTO(repairVO))
                .collect(Collectors.toList());
    }
}

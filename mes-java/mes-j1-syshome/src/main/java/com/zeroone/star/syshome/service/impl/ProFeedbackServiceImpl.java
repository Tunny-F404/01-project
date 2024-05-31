package com.zeroone.star.syshome.service.impl;

import com.zeroone.star.project.j1.syshome.dto.toDoEvent.ToDoEventDTO;
import com.zeroone.star.syshome.entity.ProFeedback;
import com.zeroone.star.syshome.entity.vo.toDoEvent.ToDoEventVO;
import com.zeroone.star.syshome.entity.vo.workshop.WorkshopVO;
import com.zeroone.star.syshome.mapper.CalTeamMemberMapper;
import com.zeroone.star.syshome.mapper.ProFeedbackMapper;
import com.zeroone.star.syshome.service.IProFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 生产报工记录表 服务实现类
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
@Service
public class ProFeedbackServiceImpl extends ServiceImpl<ProFeedbackMapper, ProFeedback> implements IProFeedbackService {

    @Resource
    MsSysHomeMapper msSysHomeMapper;
    @Resource
    ProFeedbackMapper proFeedbackMapper;
    @Override
    public List<ToDoEventDTO> listFeedback(String userName) {
        List<ToDoEventVO> feedbackVOList = proFeedbackMapper.selectFeedback(userName);
        return feedbackVOList.stream().map(feedbackVO -> msSysHomeMapper.toDoEventVOTotoDoEventDTO(feedbackVO))
                .collect(Collectors.toList());
    }
}

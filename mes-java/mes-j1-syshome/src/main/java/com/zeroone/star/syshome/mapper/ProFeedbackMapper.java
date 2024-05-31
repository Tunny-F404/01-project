package com.zeroone.star.syshome.mapper;

import com.zeroone.star.syshome.entity.ProFeedback;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.syshome.entity.vo.toDoEvent.ToDoEventVO;
import com.zeroone.star.syshome.entity.vo.workshop.WorkshopVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 生产报工记录表 Mapper 接口
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
@Mapper
public interface ProFeedbackMapper extends BaseMapper<ProFeedback> {

    @Select("SELECT f.feedback_code code, f.status FROM pro_feedback f WHERE f.user_name = #{userName}) AND (f.status = '审批中' OR f.status = '已确认'")
    List<ToDoEventVO> selectFeedback(String userName);

}

package com.zeroone.star.syshome.mapper;

import com.zeroone.star.syshome.entity.ProTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.syshome.entity.vo.toDoEvent.ToDoEventVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 生产任务表 Mapper 接口
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
@Mapper
public interface ProTaskMapper extends BaseMapper<ProTask> {

    @Select("SELECT t.task_code code FROM pro_task t JOIN pro_user_workstation uw ON r.repair_id = rl.repair_id WHERE r.accepted_by = #{userName}) AND r.finish_date = NULL")
    List<ToDoEventVO> selectTask(String userName);
}

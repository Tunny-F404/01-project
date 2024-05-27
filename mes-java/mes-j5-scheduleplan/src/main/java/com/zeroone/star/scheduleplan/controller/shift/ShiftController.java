package com.zeroone.star.scheduleplan.controller.shift;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanAddDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanModifyDTO;
import com.zeroone.star.project.j5.query.scheduleplan.shiftplan.ShiftPlanQuery;
import com.zeroone.star.project.j5.scheduleplan.shift.ShiftApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.scheduleplan.service.ICalShiftService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 描述：班次控制器
 * </p>
 * @author interstellar
 * @version 1.0.0
 */
@RestController
@RequestMapping("sch-manage/sch-plan/shift")
@Api(tags = "班次接口")
public class ShiftController implements ShiftApis {
    @Resource
    ICalShiftService calShiftService;
    @GetMapping("/list")
    @ApiOperation("获取班次列表（条件+分页）")
    @Override
    public JsonVO<PageDTO<ShiftPlanDTO>> queryShiftPlanByPlanId(ShiftPlanQuery shiftPlanQuery) {
//         TODO　查询班次列表业务处理
        //数据能正常传递到后端
//        System.out.println(shiftPlanQuery.getPageIndex());
//        System.out.println(shiftPlanQuery.getPlanId());
//        System.out.println(shiftPlanQuery.getPageSize());
//        System.out.println(shiftPlanQuery.getClass());
        PageDTO<ShiftPlanDTO> pageDTO = calShiftService.queryShiftPlanByPlanId(shiftPlanQuery);
        return JsonVO.success(pageDTO);
//        return null;
    }

    @PutMapping("/modify")
    @ApiOperation("修改班次")
    @Override
    public JsonVO<ResultStatus> modifyShiftPlan(@RequestBody ShiftPlanModifyDTO shiftPlanModifyDto) {
        //判断planId是否为空
        if(shiftPlanModifyDto.getPlanId() == null){
            return JsonVO.fail(null);
        }
        //TODO 修改班次业务
        ResultStatus status = calShiftService.modifyShiftPlan(shiftPlanModifyDto);

        //业务层返回修改信息
        return JsonVO.success(status);
    }

    @DeleteMapping("/remove/{shiftIds}")
    @ApiOperation("删除班次（支持批量删除）")
    @Override
    public JsonVO<Long> removeShiftPlan(@PathVariable List<Long> shiftIds) {
        shiftIds.forEach(System.out::println);
        // TODO 删除班次业务操作
        return JsonVO.success(1L);
    }

    @PostMapping("/add")
    @ApiOperation("添加班次")
    @Override
    public JsonVO<ResultStatus> addShiftPlan(@RequestBody ShiftPlanAddDTO shiftPlanAddDto) {
        System.out.println(shiftPlanAddDto);

        // TODO 执行新增业务处理操作
        ResultStatus status = calShiftService.addShiftPlan(shiftPlanAddDto);

        //返回操作结果
        return JsonVO.success(status);
    //            if(shiftPlanAddDto.getShiftName() == null){
    //                return JsonVO.fail(ResultStatus.FAIL);
    //            } else {
    ////                Long newShiftId = calShiftService.addShiftPlan(shiftPlanAddDto);
    //                Long newShiftId = 1L;
    //                if(newShiftId != null){
    //                    return JsonVO.success(ResultStatus.SUCCESS);
    //                }
    //                return JsonVO.success(ResultStatus.FAIL);
    //            }
        }
}

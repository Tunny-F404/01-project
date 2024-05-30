package com.zeroone.star.scheduleplan.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.j5.dto.scheduleplan.PlanDTO;
import com.zeroone.star.scheduleplan.entity.CalPlan;
import com.zeroone.star.scheduleplan.mapper.CalPlanMapper;
import com.zeroone.star.scheduleplan.service.ICalPlanService;
import org.mapstruct.Mapper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 排班计划表 服务实现类
 * </p>
 *
 */
@Mapper(componentModel = "spring")
interface MsPlanMapper {
    /**
     * 实体类转DTO
     *
     * @param calPlan 计划do对象
     * @return 计划dto对象
     */
    PlanDTO planToPlanDTO(CalPlan calPlan);

    /**
     * 计划DTO转实体类
     *
     * @param planDTO
     * @return
     */
    CalPlan PlanDTOToplan(PlanDTO planDTO);
}

@Service
public class CalPlanServiceImpl extends ServiceImpl<CalPlanMapper, CalPlan> implements ICalPlanService {

    @Resource
    private MsPlanMapper msPlanMapper;
    @Resource
    private CalPlanMapper planMapper;

    /**
     * 删除排班计划(可批量删除)
     *
     * @param rems 删除数据的id集合
     * @return
     */
    @Override
    public boolean removeSchPlan(List<Long> rems) {
        return planMapper.deleteBatchIds(rems) > 0;
    }

    @Override
    public boolean modifySchPlanStatus(PlanDTO condition) {
        //1.查询当前数据是否存在
        CalPlan modifyPlan = baseMapper.selectById(condition.getPlanId());
        //2.数据不存在,修改失败,返回false
        if (modifyPlan == null) {
            return false;
        }
        //3.存在则执行修改操作---将DTO转为DO
        CalPlan calPlan = msPlanMapper.PlanDTOToplan(condition);

        return baseMapper.updateById(calPlan) > 0;
    }

    @Override
    public ResponseEntity<byte[]> exportSchPlan(List<Long> ids) {
        //导出计划数据列表
        List<CalPlan> planlist = new ArrayList<>();
        //从导出id列表中依次取出id进行查询数据
        for (Long id : ids) {
            CalPlan plan = planMapper.selectById(id);
            //查出数据不为空则将其加入数据列表
            if (plan != null) {
                planlist.add(plan);
            }
        }
        //如果导出后没有数据->返回一个404 Not Found的HTTP响应
        if (planlist.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        //输出流，用于将数据写入到一个字节数组中,捕获 EasyExcel 导出操作生成的Excel文件的字节数据
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
            EasyExcelComponent easyExcelComponent = new EasyExcelComponent();
            //使用easyExcelComponent的export方法将clientList中的数据导出到输出流中
            easyExcelComponent.export("计划列表", os, CalPlan.class, planlist);
            byte[] bytes = os.toByteArray();
            String filename = "scheduleplans-" + DateTime.now().toString("yyyyMMddHHmmss") + ".xlsx";
            HttpHeaders header = new HttpHeaders();
            //指定响应体应该如何被处理,"attachment" 表示响应体应该被下载为一个文件
            header.setContentDispositionFormData("attachment", filename);
            // 设置响应头，指示响应体是一个二进制流，通常用于文件下载。
            header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<>(bytes, header, HttpStatus.CREATED);
        } catch (IOException e) {
            // 记录日志并返回错误信息
            log.error("导出Excel文件时发生错误", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("导出Excel文件时发生错误：" + e.getMessage()).getBytes());
        }
    }
}

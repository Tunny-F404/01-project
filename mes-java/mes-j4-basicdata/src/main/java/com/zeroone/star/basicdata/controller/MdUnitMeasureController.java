package com.zeroone.star.basicdata.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.basicdata.service.IMdUnitMeasureService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.j4.basicdata.entity.MdUnitMeasure;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/basicdata/md-unit-measure")
@Api(tags = "单位管理")
public class MdUnitMeasureController {

    @Autowired
    private IMdUnitMeasureService mdUnitMeasureService;

    /**
     * 查询单位分页列表
     * @param mdUnitMeasure 单位测量模型，用于筛选查询条件
     * @return 返回单位列表的信息
     */
    @GetMapping("/list")
    @ApiOperation("查询单位分页列表")
    public JsonVO<PageDTO<MdUnitMeasure>> list(MdUnitMeasure mdUnitMeasure) {

        // 查询符合条件的单位列表
        List<MdUnitMeasure> list = mdUnitMeasureService.selectMdUnitMeasureList(mdUnitMeasure);

        // 将查询结果放入Page对象
        Page<MdUnitMeasure> page = new Page<>(1, 10, list.size());
        page.setRecords(list);

        // 将Page对象转换为PageDTO对象
        PageDTO<MdUnitMeasure> pageDTO = PageDTO.create(page);

        return JsonVO.success(pageDTO);
    }

}

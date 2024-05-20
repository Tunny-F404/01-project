package com.zeroone.star.syshome.controller;

import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.j1.syshome.SysHomeApis;
import com.zeroone.star.project.j1.syshome.dto.PageDTO;
import com.zeroone.star.project.j1.syshome.dto.facility.FacilityDTO;
import com.zeroone.star.project.j1.syshome.dto.production.ProductionDTO;
import com.zeroone.star.project.j1.syshome.dto.quality.QualityDTO;
import com.zeroone.star.project.j1.syshome.dto.repertory.RepertoryDTO;
import com.zeroone.star.project.j1.syshome.query.production.ProductionQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;


/**
 * <p>
 * 描述：TODO
 * </p>
 * @author twelve
 * @version 1.0.0
 */
@RestController
@RequestMapping("syshome")
@Api(tags = "系统首页")
public class SysHomeController implements SysHomeApis {


    @GetMapping("query-production-table")
    @ApiOperation(value = "生产进度列表")
    @Override
    public JsonVO<PageDTO<ProductionDTO>> queryProduction(ProductionQuery condition){
        return null;
    }


    @GetMapping("query-repertory")
    @ApiOperation(value = "库存统计饼图")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "仓库编号", dataType = "String", paramType = "query", required = true,example = "F055")
    })
    @Override
    public JsonVO<List<RepertoryDTO>> queryRepertory(@PathVariable String id) {
        return null;
    }

    @GetMapping("query-facility")
    @ApiOperation(value = "设备信息表")
    @Override
    public JsonVO<FacilityDTO> queryFacility() {
        return null;
    }

    @GetMapping("query-quality")
    @ApiOperation(value = "质量统计饼图")
    @Override
    public JsonVO<List<QualityDTO>> queryQuality() {
        return null;
    }
}

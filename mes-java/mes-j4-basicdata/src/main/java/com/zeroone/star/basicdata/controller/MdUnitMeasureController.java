package com.zeroone.star.basicdata.controller;
import com.zeroone.star.basicdata.service.IMdUnitMeasureService;
import com.zeroone.star.project.dto.j4.basicdata.UnitExcelSelectDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import java.util.List;

/**
 * <p>
 * 单位表 前端控制器
 * </p>
 *
 * @author zjx
 * @since 2024-05-20
 */
@RestController
@RequestMapping("/basicdata/md-unit-measure")
@Api(tags = "单位相关操作")
public class MdUnitMeasureController {

    @Resource
    private IMdUnitMeasureService iMdUnitMeasureService;

    /*
     * 删除单位
     * */
    @ApiOperation(value = "删除单位")
    @DeleteMapping("/delete-by-measureIds")
    public JsonVO<String> deleteUnitMeasure(@RequestParam List<Long> measureIds) {
        Long isRemoved = iMdUnitMeasureService.deleteByIds(measureIds);
        if (isRemoved == 0) {
            return JsonVO.fail("删除失败");
        }
        return JsonVO.success("删除成功");
    }

    /*
     * 导出单位
     * */
    @ApiOperation(value = "导出单位")
    @GetMapping(value = "/download-unitMeasure", produces = "application/octet-stream")
    public ResponseEntity<byte[]> exportUnitMeasure(UnitExcelSelectDTO unitExcelSelectDTO) {
        ResponseEntity<byte[]> responseEntity = iMdUnitMeasureService.exportUnitMeasure(unitExcelSelectDTO);
        return responseEntity;
    }

}

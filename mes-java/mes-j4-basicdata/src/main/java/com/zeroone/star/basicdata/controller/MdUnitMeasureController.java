package com.zeroone.star.basicdata.controller;

import com.zeroone.star.basicdata.service.IMdUnitMeasureService;
import com.zeroone.star.project.dto.j4.basicdata.UnitExcelSelectDTO;
import com.zeroone.star.project.j4.basicdata.AccountUnitApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 单位相关操作 前端控制器
 * </p>
 *
 * @author 本鼠
 * @since 2024-05-21
 */

@RestController
@RequestMapping("/basicData")
@Api(tags = "单位相关操作")
public class MdUnitMeasureController implements AccountUnitApis {

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

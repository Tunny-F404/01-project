package com.zeroone.star.sysmanager.service.impl;

import cn.hutool.core.date.DateTime;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.components.poi.ExcelComponent;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictDataDetailDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictDataExportDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictDataListDTO;
import com.zeroone.star.project.j3.query.dict.SysDictDataQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanager.entity.SysDictData;
import com.zeroone.star.sysmanager.entity.SysDictType;
import com.zeroone.star.sysmanager.mapper.SysDictDataMapper;
import com.zeroone.star.sysmanager.service.ISysDictDataService;
import org.mapstruct.Mapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements ISysDictDataService {

    @Resource
    private TsSysDictDataMapper tsSysDictDataMapper;

    @Resource
    private EasyExcelComponent excelComponent;

    @Override
    public JsonVO<PageDTO<SysDictDataListDTO>> listDictData(SysDictDataQuery dictDataQuery) {
        // 开始分页
        Page<SysDictData> pageType = new Page<>(dictDataQuery.getPageIndex(), dictDataQuery.getPageSize());

        page(pageType, new LambdaQueryWrapper<SysDictData>()
                .eq(SysDictData::getDictType, dictDataQuery.getDictType())
                .like(dictDataQuery.getDictLabel() != null,
                        SysDictData::getDictLabel, dictDataQuery.getDictLabel())
                .eq(dictDataQuery.getStatus() != null,
                        SysDictData::getStatus, dictDataQuery.getStatus())
        );

        return JsonVO.success(PageDTO.create(pageType, tsSysDictDataMapper::toDto));
    }

    @Override
    public ResponseEntity<byte[]> exportDictData(SysDictDataExportDTO sysDictDataExportDTO) {

        // 查询内容
        try( ByteArrayOutputStream excel = new ByteArrayOutputStream() ) {

            List<SysDictDataListDTO> list = list(new LambdaQueryWrapper<SysDictData>()
                    .eq(SysDictData::getDictType, sysDictDataExportDTO.getDictType())
                    .like(sysDictDataExportDTO.getDictLabel() != null,
                            SysDictData::getDictLabel, sysDictDataExportDTO.getDictLabel())
                    .eq(sysDictDataExportDTO.getStatus() != null,
                            SysDictData::getStatus, sysDictDataExportDTO.getStatus()))
                    .stream().map(tsSysDictDataMapper::toDto)
                    .collect(Collectors.toList());

            //easyexcel构建输出流
            String filename= UUID.randomUUID() + ".xls";
            excelComponent.export(UUID.randomUUID().toString(), excel, SysDictDataListDTO.class, list);

            //构建响应头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",filename);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return new ResponseEntity<>(excel.toByteArray(), headers, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JsonVO<SysDictDataDetailDTO> getDictData(Long dictCode) {
        return JsonVO.success(tsSysDictDataMapper.toDetailDTO(getById(dictCode)));
    }
}

@Mapper(componentModel = "spring")
interface TsSysDictDataMapper {
    SysDictDataListDTO toDto(SysDictData sysDictData);

    SysDictDataDetailDTO toDetailDTO(SysDictData sysDictData);
}

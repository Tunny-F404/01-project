package com.zeroone.star.basicdata.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.basicdata.entity.MdUnitMeasure;
import com.zeroone.star.basicdata.mapper.MdUnitMeasureMapper;
import com.zeroone.star.basicdata.service.IMdUnitMeasureService;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.project.components.user.UserHolder;
import com.zeroone.star.project.dto.j4.basicdata.UnitAddDTO;
import com.zeroone.star.project.dto.j4.basicdata.UnitExcelSelectDTO;
import com.zeroone.star.project.dto.j4.basicdata.UnitMeasureDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 单位表 服务实现类
 * </p>
 *
 * @author 本鼠
 * @since 2024-05-21
 */
@Service
@Slf4j
public class MdUnitMeasureServiceImpl extends ServiceImpl<MdUnitMeasureMapper, MdUnitMeasure> implements IMdUnitMeasureService {


    @Resource
    private MdUnitMeasureMapper mdUnitMeasureMapper;

    @Resource
    private EasyExcelComponent excel;

    @Resource
    private UserHolder userHolder;

    /*
     * 删除单位
     * */
    public Long deleteByIds(List<Long> idList) {
        return mdUnitMeasureMapper.deleteByIds(idList);
    }

    /*
     * 导出单位数据
     * */
    @SneakyThrows
    public ResponseEntity<byte[]> exportUnitMeasure(UnitExcelSelectDTO unitExcelSelectDTO) {
        //查询到导出文件的数据
        List<MdUnitMeasure> unitMeasureList = mdUnitMeasureMapper.listUnitMeasure(unitExcelSelectDTO);
        //创建输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        //导出数据到输出流
        excel.export("导出单位", out, MdUnitMeasure.class, unitMeasureList);

        //获取字节数据
        byte[] bytes = out.toByteArray();
        out.close();

        //构建响应头
        HttpHeaders headers = new HttpHeaders();
        String filename = "unitmeasure-" + DateTime.now().toString("yyyyMMddHHmmssS") + ".xlsx";
        //headers.setContentDispositionFormData("attachment", filename);
        headers.add("Content-Disposition", "attachment;filename=" + filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        //响应文件给客户端
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

    /**
     * 查询单位列表
     *
     * @param mdUnitMeasure
     * @return
     */
    @Override
    public List<UnitMeasureDTO> selectMdUnitMeasureList(UnitMeasureDTO mdUnitMeasure) {
        return mdUnitMeasureMapper.selectMdUnitMeasureList(mdUnitMeasure);
    }

    @Override
    public Boolean addUnit(UnitAddDTO data) {
        try {
            UserDTO userDTO = userHolder.getCurrentUser();
            MdUnitMeasure mdUnitMeasure = new MdUnitMeasure();
            BeanUtil.copyProperties(data, mdUnitMeasure);
            mdUnitMeasure.setCreateBy(userDTO.getUsername());
            mdUnitMeasure.setUpdateBy(userDTO.getUsername());
            mdUnitMeasure.setCreateTime(LocalDateTime.now());
            mdUnitMeasure.setUpdateTime(LocalDateTime.now());
            return mdUnitMeasureMapper.insert(mdUnitMeasure) > 0;
        } catch (Exception e) {
            log.info("添加单位失败",e.getMessage());
            return false;
        }
    }
}

package com.zeroone.star.productManagement.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zeroone.star.productManagement.entity.MdItem;
import com.zeroone.star.productManagement.mapper.MdItemMapper;
import com.zeroone.star.productManagement.service.IMdItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.j6.product_management.query.MdItemQuery;
import io.swagger.models.auth.In;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 物料产品表 服务实现类
 * </p>
 *
 * @author xiaotian
 * @since 2024-05-20
 */
@Service
public class MdItemServiceImpl extends ServiceImpl<MdItemMapper, MdItem> implements IMdItemService {
    @Autowired
    private MdItemMapper mdItemMapper;
    @Autowired
    EasyExcelComponent excel;
    public List<MdItem> selectMdItemList(MdItemQuery mdItemQuery) {

        return mdItemMapper.selectMdItemList(mdItemQuery);
    }

    @SneakyThrows
    public ResponseEntity<byte[]> exportToExcel(List<MdItem> items) {
        try {
            // 构建一个输出流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            // 导出数据到输出流
            excel.export("物料产品列表", out, MdItem.class, items);
            // 获取字节数据
            byte[] bytes = out.toByteArray();
            out.close();

            // 构建响应头
            HttpHeaders headers = new HttpHeaders();
            String filename = "report-" + DateTime.now().toString("yyyyMMddHHmmssS") + ".xlsx";
            headers.setContentDispositionFormData("attachment", filename);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            // 响应文件给客户端
            return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

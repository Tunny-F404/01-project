package com.zeroone.star.productManagement.service.impl;

import cn.hutool.core.date.DateTime;
import com.alibaba.excel.EasyExcel;
import com.zeroone.star.productManagement.entity.MdItem;
import com.zeroone.star.productManagement.mapper.MdItemMapper;
import com.zeroone.star.productManagement.service.IMdItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.j6.product_management.query.MdItemQuery;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

    /**
     * 根据条件查询物料列表
     * @param mdItemQuery 查询条件
     * @return 物料列表
     */
    public List<MdItem> selectMdItemList(MdItemQuery mdItemQuery) {

        return mdItemMapper.selectMdItemList(mdItemQuery);
    }

    /**
     * 导出数据
     * @param items 物料数据
     * @return 返回响应
     */
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

    /**
     * 初始化产品物料模板
     * @return MdItem对象
     */
    private MdItem initTemplate() {
        MdItem item = new MdItem();
        item.setItemId(null);
        item.setItemCode("");
        item.setItemName("");
        item.setSpecification("");
        item.setUnitOfMeasure("");
        item.setItemOrProduct("");
        item.setItemTypeId(null);
        item.setItemTypeCode("");
        item.setItemTypeName("");
        item.setEnableFlag("");
        item.setSafeStockFlag("");
        item.setMinStock(null);
        item.setMaxStock(null);
        item.setRemark("");
        return item;
    }

    /**
     * 下载模板
     * @return 返回响应
     */
    public ResponseEntity<byte[]> downloadTemplate(){
        try {
            List<MdItem> items = new ArrayList<>();
            items.add(initTemplate());
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
            // 处理异常并返回适当的错误响应
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public JsonVO<String> importFromExcel(MultipartFile file, boolean updateSupport) {
        List<MdItem> items = new ArrayList<>();
        // excel同步读取数据
        try {
            items = EasyExcel.read(new BufferedInputStream(file.getInputStream())).head(MdItem.class).sheet().doReadSync();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        // 根据需求执行插入或更新操作
//        if (updateSupport) {
//            updateOrInsertData(items);
//        } else {
//            insertItems(items);
//        }
        return null;
    }


}

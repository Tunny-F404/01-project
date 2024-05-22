package com.zeroone.star.basicdata.service.impl;

import cn.hutool.core.date.DateTime;
import com.zeroone.star.basicdata.entity.MdVendor;
import com.zeroone.star.basicdata.mapper.MdVendorMapper;
import com.zeroone.star.basicdata.service.IMdVendorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.dto.j4.basicdata.VendorDTO;
import com.zeroone.star.project.dto.j4.basicdata.VendorExcelSelectDTO;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * <p>
 * 供应商表 服务实现类
 * </p>
 *
 * @author 本鼠
 * @since 2024-05-21
 */
@Service
public class MdVendorServiceImpl extends ServiceImpl<MdVendorMapper, MdVendor> implements IMdVendorService {

    @Resource
    private MdVendorMapper mdVendorMapper;

    @Resource
    private EasyExcelComponent excel;
    /*
    * 导出供应商
    * */
    @SneakyThrows
    @Override
    public ResponseEntity<byte[]> exportVendor(VendorExcelSelectDTO vendorExcelSelectDTO) {
        //查询到导出文件的数据
        List<MdVendor> vendorList = mdVendorMapper.listVendor(vendorExcelSelectDTO);
        //创建输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        //导出数据到输出流
        excel.export("导出单位", out,MdVendor.class, vendorList);

        //获取字节数据
        byte[] bytes = out.toByteArray();
        out.close();

        //构建响应头
        HttpHeaders headers = new HttpHeaders();
        String filename = "vendor-" + DateTime.now().toString("yyyyMMddHHmmssS") + ".xlsx";
        //headers.setContentDispositionFormData("attachment", filename);
        headers.add("Content-Disposition", "attachment;filename=" + filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        //响应文件给客户端
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

    @Override
    public int addVendor(VendorDTO data){
        MdVendor mdVendor = new MdVendor();
        BeanUtils.copyProperties(data, mdVendor);
        return mdVendorMapper.insert(mdVendor);
    }
}

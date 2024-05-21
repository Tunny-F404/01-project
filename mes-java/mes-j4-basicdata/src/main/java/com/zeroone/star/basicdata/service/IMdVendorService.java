package com.zeroone.star.basicdata.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.basicdata.entity.MdVendor;
import com.zeroone.star.project.dto.j4.basicdata.VendorExcelSelectDTO;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

/**
 * <p>
 * 供应商表 服务类
 * </p>
 *
 * @author 本鼠
 * @since 2024-05-21
 */
public interface IMdVendorService extends IService<MdVendor> {

    /*
    * 导出供应商
    * */
    ResponseEntity<byte[]> exportVendor(VendorExcelSelectDTO vendorExcelSelectDTO);
}

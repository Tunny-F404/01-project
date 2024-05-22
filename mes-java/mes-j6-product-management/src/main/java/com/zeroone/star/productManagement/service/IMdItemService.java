package com.zeroone.star.productManagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zeroone.star.productManagement.entity.MdItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.j6.product_management.query.MdItemQuery;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * <p>
 * 物料产品表 服务类
 * </p>
 *
 * @author xiaotian
 * @since 2024-05-20
 */
public interface IMdItemService extends IService<MdItem> {
    List<MdItem> selectMdItemList(MdItemQuery query);

    ResponseEntity<byte[]> exportToExcel(List<MdItem> items);
}

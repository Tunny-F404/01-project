package com.zeroone.star.project.j6.product_management;


import com.zeroone.star.project.vo.JsonVO;

public interface SupplierApis {
    JsonVO querySupplierList();
    JsonVO addSupplierList();
    JsonVO updateSupplier();
    JsonVO deleteBatchSupplier();
}

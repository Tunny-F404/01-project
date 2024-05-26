#include "stdafx.h"
#include "ProdWorkorderService.h"
#include "../../dao/ProdWorkorder/ProdWorkorderDAO.h"

ProdWorkorderInfoDTO::Wrapper ProdWorkorderService::listDetail(const ProdWorkorderInfoDTO::Wrapper& dto) {
	// 组装DO数据
	ProdWorkorderInfoDO data;
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Workorder_id, workorder_id, Workorder_code, workorder_code, Workorder_name, workorder_name, Order_source, order_source, Source_code, source_code, Status, status, Workorder_type, workorder_type, Product_code, product_code, Product_name, product_name, Product_spc, product_spc, Unit_of_measure, unit_of_measure, Quantity, quantity, Request_date, request_date, Batch_code, batch_code, Client_code, client_code, Client_name, client_name, Vendor_code, vendor_code, Vendor_name, vendor_name, Remark, remark)
	// 执行数据添加
	ProdWorkorderDAO dao;
	return dao.selectByWorkorderId(data);
}
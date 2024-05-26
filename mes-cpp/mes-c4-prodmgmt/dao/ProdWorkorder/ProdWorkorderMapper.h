#pragma once
#ifndef _PRODWORKORDER_MAPPER_
#define _PRODWORKORDER_MAPPER_

#include "Mapper.h"
#include "../../domain/do/ProdWorkorder/AddProdWorkorderDO.h"
#include "../../domain/do/ProdWorkorder/GetProdWorkorderListDO.h"
#include "../../domain/do/ProdWorkorder/ProdWorkorderBomListDO.h"
#include "../../domain/do/ProdWorkorder/ProdWorkorderInfoDO.h"

/**
 * 获取生产工单详情
 */
class ProdWorkorderInfoMapper : public Mapper<ProdWorkorderInfoDO>
{
public:
	ProdWorkorderInfoDO mapper(ResultSet* resultSet) const override
	{
		ProdWorkorderInfoDO data;
		//工单ID;workorder_id;bigint
		data.setWorkorder_id(resultSet->getUInt64(1));
		//工单编码;workorder_code;varchar
		data.setWorkorder_code(resultSet->getString(2));
		//工单名称;workorder_name;varchar
		data.setWorkorder_name(resultSet->getString(3));
		//来源类型;order_source;varchar
		data.setOrder_source(resultSet->getString(4));
		//订单编号;source_code;varchar
		data.setSource_code(resultSet->getString(5));
		//单据状态;status;varchar
		data.setStatus(resultSet->getString(6));
		//工单类型;workorder_type;varchar
		data.setWorkorder_type(resultSet->getString(7));
		//产品编号;product_code;varchar
		data.setProduct_code(resultSet->getString(8));
		//产品名称;product_name;varchar
		data.setProduct_name(resultSet->getString(9));
		//规格型号;product_spc;varchar
		data.setProduct_spc(resultSet->getString(10));
		//单位;unit_of_measure;varchar
		data.setUnit_of_measure(resultSet->getString(11));
		//工单数量（生产数量）;quantity;double
		data.setQuantity(resultSet->getDouble(12));
		//需求日期;request_date;datetime
		data.setRequest_date(resultSet->getString(13));
		//批次号;batch_code;varchar
		data.setBatch_code(resultSet->getString(14));
		//客户编码;client_code;varchar
		data.setClient_code(resultSet->getString(15));
		//客户名称;client_name;varchar
		data.setClient_name(resultSet->getString(16));
		//供应商编码;vendor_code;varchar
		data.setVendor_code(resultSet->getString(17));
		//供应商名称;vendor_name;varchar
		data.setVendor_name(resultSet->getString(18));
		//备注;remark;varchar
		data.setRemark(resultSet->getString(19));
		return data;
	}
};


#endif // !_PRODWORKORDER_MAPPER_
#pragma once
#ifndef _MODIFYWHSTORAGEORDER_DO_
#define _MODIFYWHSTORAGEORDER_DO_
/*
修改入库单行的数据库实体类
*/
#include "../../DoInclude.h"
class ModifyWhStorageorderDO
{
	////入库单名称 recpt_name varchar
	CC_SYNTHESIZE(string, recpt_name, Recpt_name);
	//入库单编号 recpt_code varchar
	CC_SYNTHESIZE(string, recpt_code, Recpt_code);
	//供应商名称 vendor_name varchar
	CC_SYNTHESIZE(string, vendor_name, Vendor_name);
	//采购订单号 po_code varchar
	CC_SYNTHESIZE(string, po_code, Po_code);
	//单据状态 status varchar
	CC_SYNTHESIZE(string, status, Status);
	//入库日期 recpt_date String
	CC_SYNTHESIZE(string, recpt_date, Recpt_date);
	//入库仓库 warehouse_name varchar
	CC_SYNTHESIZE(string, warehouse_name, Warehouse_name);
	//备注 remark varchar
	CC_SYNTHESIZE(string, remark, Remark);

public:
	ModifyWhStorageorderDO() {
		recpt_name = "";
		recpt_code = "";
		vendor_name = "";
		po_code = "";
		status = "";
		recpt_date = "";
		warehouse_name = "";
		remark = "";
	}
};
#endif // !_MODIFYWHSTORAGEORDER_DO_

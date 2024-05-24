#pragma once
#ifndef _MODIFYWHSTORAGEORDER_DO_
#define _MODIFYWHSTORAGEORDER_DO_
/*
修改入库单行的数据库实体类
*/
#include "../../DoInclude.h"
class ModifyWhStorageorderDO
{
	//物料编码 item_code varchar
	CC_SYNTHESIZE(string, item_code, Item_code);
	//物料名称 item_name varchar
	CC_SYNTHESIZE(string, item_name, Item_name);
	//单位 unit_of_measure varchar
	CC_SYNTHESIZE(string, unit_of_measure, Unit_of_measure);
	//入库数量 quantity_recived double
	CC_SYNTHESIZE(double, quantity_recived, Quantity_recived);
	//入库批次号 batch_code varchar
	CC_SYNTHESIZE(string, batch_code, Batch_code);
	//有效期 expire_date String
	CC_SYNTHESIZE(string, expire_date, Expire_date);
	//入库仓库 warehouse_name varchar
	CC_SYNTHESIZE(string, warehouse_name, Warehouse_name);
	//是否检验 iqc_check char
	CC_SYNTHESIZE(string, iqc_check, Iqc_check);
	//来料检验单编码 iqc_code varchar
	CC_SYNTHESIZE(string, iqc_code, Iqc_code);
	//来料检验单ID iqc_id bigint
	CC_SYNTHESIZE(uint64_t, iqc_id, Iqc_id);
	//备注 remark varchar
	CC_SYNTHESIZE(string, remark, Remark);

public:
	ModifyWhStorageorderDO() {
		item_code = "";
		item_name = "";
		unit_of_measure = "";
		quantity_recived = 0.00;
		batch_code = "";
		expire_date = "";
		warehouse_name = "";
		iqc_check = "";
		iqc_code = "";
		iqc_id = 0;
		remark = "";
	}
};
#endif // !_MODIFYWHSTORAGEORDER_DO_

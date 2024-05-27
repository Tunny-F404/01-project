#include "stdafx.h"
#include "AddWhStorageorderController.h"
#include "../../../service/ProchAndStorage/MaterialsInfo/WhStorageorderService.h"
#include "../../ApiDeclarativeServicesHelper.h"

Uint64JsonVO::Wrapper AddWhStorageorderController::execAddWhStorageorder(const AddWhStorageorderDTO::Wrapper& dto)
{
	//定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	//参数校验
	//非空校验
	if (!dto->line_id || !dto->batch_code || !dto->expire_date || !dto->iqc_check  || !dto->remark || !dto->item_id
		|| !dto->item_code || !dto->item_name ||  !dto->warehouse_name || !dto->unit_of_measure || !dto->quantity_recived) {
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	//有效值校验
	if (dto->line_id < 0 || dto->batch_code->empty() || dto->expire_date->empty() || dto->remark->empty() || dto->item_id < 0
		|| dto->iqc_id < 0 || dto->item_code->empty() || dto->item_name->empty() || dto->warehouse_name->empty() || dto->unit_of_measure->empty() || dto->quantity_recived < 0.00) {
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	//定义一个Service
	WhStorageorderService service;
	//执行数据新增
	uint64_t id = service.addWhStorageorder(dto);
	printf("ADD:%d\n", id);
	if (id > 0) {
		jvo->success(UInt64(id));
	}
	else
	{
		jvo->fail(UInt64(id));
	}
	//响应结果
	return jvo;
}
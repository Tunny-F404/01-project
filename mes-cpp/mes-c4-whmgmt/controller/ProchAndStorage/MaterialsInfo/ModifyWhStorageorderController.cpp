#include "stdafx.h"
#include "ModifyWhStorageorderController.h"
#include "../../ApiDeclarativeServicesHelper.h"
#include "../../../service/ProchAndStorage/MaterialsInfo/WhStorageorderService.h"

Uint64JsonVO::Wrapper ModifyWhStorageorderController::execModifyWhStorageorder(const ModifyWhStorageorderDTO::Wrapper& dto)
{
	//定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	//参数校验
	if (!dto->line_id || !dto->batch_code || !dto->expire_date || !dto->iqc_check  || !dto->remark
		|| !dto->item_code || !dto->item_name || !dto->warehouse_name || !dto->unit_of_measure || !dto->quantity_recived) {
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	//定义一个service
	WhStorageorderService service;

	//执行数据修改
	if (service.modifyWhStorageorder(dto)) {
		jvo->success(dto->line_id);
	}
	else
	{
		jvo->fail(dto->line_id);
	}
	//响应结果给前端
	return jvo;
}
#include "stdafx.h"
#include "../../service/purchasereceiving/ModifyListService.h"
#include "../ApiDeclarativeServicesHelper.h"

#include "ModifyListController.h"

Uint64JsonVO::Wrapper ModifyListController::execModifyList(const ModifyListDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	//!dto->recptcode || !dto->recptname || 
	//!dto->recptdate || !dto->pocode || !dto->status || !dto->vendorid ||
		//!dto->warehousename || !dto->remark
	if (!dto->recptid || dto->recptid <= 0)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 定义一个Service
	ModifyListService service;
	// 执行数据修改
	if (service.updateData(dto)) {
		jvo->success(dto->recptid);
	}
	else
	{
		jvo->fail(dto->recptid);
	}
	// 响应结果
	return jvo;
}

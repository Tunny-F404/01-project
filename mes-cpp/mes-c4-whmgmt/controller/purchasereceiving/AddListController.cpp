#include "stdafx.h"
#include "../../service/purchasereceiving/AddListService.h"
#include "../ApiDeclarativeServicesHelper.h"
#include "AddListController.h"

Uint64JsonVO::Wrapper AddListController::execAddList(const AddListDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	// 非空校验
	if (!dto->recptcode || !dto->recptname || !dto->recptdate || !dto->pocode || !dto->status || !dto-> vendorid || !dto->warehousename || !dto->remark)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 有效值校验
	if (dto->recptcode->empty() || dto->recptname->empty() || dto->recptdate->empty() || dto->pocode->empty() || dto->status->empty() || dto->vendorid < 0 || dto->warehousename->empty() || dto->remark->empty())
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	//service层 
	//.......
	// 定义一个Service
	AddListService service;
	// 执行数据新增
	uint64_t id = service.saveData(dto);
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

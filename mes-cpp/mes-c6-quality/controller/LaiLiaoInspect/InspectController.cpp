#include "stdafx.h"
#include "InspectController.h"
#include "../../service/LaiLiaoInspect/InspectService.h"
#include "../ApiDeclarativeServicesHelper.h"

InspectPageJsonVO::Wrapper InspectController::execQueryInspect(const InspectQuery::Wrapper& query, const PayloadDTO& payload)
{
	// 定义一个Service
	InspectService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = InspectPageJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

Inspect_detailJsonVO::Wrapper InspectController::execQueryInspect_detail(const int& line_id, const PayloadDTO& payload)
{
	// 定义一个Service
	InspectService service;
	// 查询数据
	auto result = service.list_detailone(line_id);
	// 响应结果
	auto jvo = Inspect_detailJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

Inspect_detailJsonVO::Wrapper InspectController::execQueryInspect_detail(const int& line_id)
{
	// 定义一个Service
	InspectService service;
	// 查询数据
	auto result = service.list_detailone(line_id);
	// 响应结果
	auto jvo = Inspect_detailJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

//查看报表
StringJsonVO::Wrapper InspectController::execLookTable(const oatpp::List<UInt64>& ids)
{
	/*return StringJsonVO::Wrapper();*/
	return {};
}


Uint64JsonVO::Wrapper InspectController::execAddInspect(const InspectDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	// 非空校验
	if ( !dto->code || !dto->name || !dto->vendor_code || !dto->item_code || !dto->quantity_recived || !dto->quantity_check  || !dto->recive_date || !dto->inspect_date)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 有效值校验
	if ( dto->item_code->empty() || dto->item_name->empty() || (dto->quantity_check> dto->quantity_recived) || dto->quantity_recived<0|| dto->quantity_check<0 || dto->quantity_unqualified>dto->quantity_check)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}

	// 定义一个Service
	InspectService service;
	// 执行数据新增
	uint64_t id = service.saveData(dto);
	if (id > 0) 
	{
		jvo->success(UInt64(id));
	}
	else
	{
		jvo->fail(UInt64(id));
	}
	//响应结果
	return jvo;
}

Uint64JsonVO::Wrapper InspectController::execModifyInspect(const InspectDTO::Wrapper& dto)
{
	//
	return {};
}

Uint64JsonVO::Wrapper InspectController::execRemoveInspect(const UInt64& id)
{
	//// 定义返回数据对象
	//auto jvo = Uint64JsonVO::createShared();
	//// 参数校验
	//if (!id || id <= 0)
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}
	//// 定义一个Service
	//InspectService service;
	//// 执行数据删除
	//if (service.removeData(id.getValue(0))) {
	//	jvo->success(id);
	//}
	//else
	//{
	//	jvo->fail(id);
	//}
	//// 响应结果
	//return jvo;
	return {};
}

//导出
StringJsonVO::Wrapper InspectController::execExportInspect(const oatpp::List<UInt64>& ids)
{
	return StringJsonVO::Wrapper();
}

//确认检验表
Uint64JsonVO::Wrapper InspectController::execIs_OkInspect(const Item_idDTO::Wrapper& dto)
{
	return{};
}

//完成检验表
Uint64JsonVO::Wrapper InspectController::execIs_FinishedInspect(const Item_idDTO::Wrapper& dto)
{
	return{};
}

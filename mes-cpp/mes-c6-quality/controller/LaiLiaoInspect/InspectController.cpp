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
Inspect_detailPageJsonVO::Wrapper InspectController::execQueryInspect_detail(const Inspect_detailQuery::Wrapper& query, const PayloadDTO& payload)
{
	return {};
}

StringJsonVO::Wrapper InspectController::execLookTable(const oatpp::List<UInt64>& ids)
{
	return StringJsonVO::Wrapper();
}


Uint64JsonVO::Wrapper InspectController::execAddInspect(const InspectDTO::Wrapper& dto)
{
	// //定义返回数据对象
	//auto jvo = Uint64JsonVO::createShared();
	// //参数校验
	// //非空校验
	//if (!dto->code || !dto->name || !dto->template_id || !dto->vendor_id || !dto->vendor_code || !dto->vendor_name || !dto->vd_nick || !dto->batch_code || !dto->warehouse_name || !dto->location_name || !dto->area_name)
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}
	//// 有效值校验
	//if (dto->issue_id <= 0 || dto->item_id <= 0 || dto->item_code->empty() || dto->item_name->empty() || dto->specification->empty() || dto->unit_of_measure->empty() || dto->quantity_issued <= 0 || dto->batch_code->empty() || dto->warehouse_name->empty() || dto->location_name->empty() || dto->area_name->empty())
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}

	//// 定义一个Service
	//InspectService service;
	//// 执行数据新增
	//uint64_t id = service.saveData(dto);
	//if (id > 0) {
	//	jvo->success(UInt64(id));
	//}
	//else
	//{
	//	jvo->fail(UInt64(id));
	//}
	////响应结果
	//return jvo;
	return {};
}

Uint64JsonVO::Wrapper InspectController::execModifyInspect(const InspectDTO::Wrapper& dto)
{
	//// 定义返回数据对象
	//auto jvo = Uint64JsonVO::createShared();
	//// 参数校验
	//if (!dto->line_id || dto->line_id <= 0)
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}
	//// 定义一个Service
	//InspectService service;
	//// 执行数据修改
	//if (service.updateData(dto)) {
	//	jvo->success(dto->line_id);
	//}
	//else
	//{
	//	jvo->fail(dto->line_id);
	//}
	//// 响应结果
	//return jvo;
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

StringJsonVO::Wrapper InspectController::execExportInspect(const oatpp::List<UInt64>& ids)
{
	return StringJsonVO::Wrapper();
}

Uint64JsonVO::Wrapper InspectController::execIs_OkInspect(const Item_idDTO::Wrapper& dto)
{
	return{};
}

Uint64JsonVO::Wrapper InspectController::execIs_FinishedInspect(const Item_idDTO::Wrapper& dto)
{
	return{};
}

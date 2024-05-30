#include "stdafx.h"
#include "ProinspectController.h"
#include "service/processinspection/Proinspect/ProinspectService.h"
#include "../../ApiDeclarativeServicesHelper.h"

Uint64JsonVO::Wrapper ProinspectController::execAddrecord(const ProinspectDTO::Wrapper& dto)
{
	//// 定义返回数据对象
	//auto jvo = Uint64JsonVO::createShared();
	//// 参数校验
	//// 非空校验
	//if (!dto->record_id || !dto->qc_type || !dto->qc_id || !dto->line_id || !dto->defect_name || !dto->defect_level || !dto->remark)
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}
	//// 有效值校验
	//if (dto->record_id < 0 || dto->qc_type->empty() || dto->qc_id < 0 || dto->line_id < 0 || dto->defect_name->empty() || dto->defect_level->empty() || dto->remark->empty())
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}

	//// 定义一个Service
	//ProinspectService service;
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



Uint64JsonVO::Wrapper ProinspectController::execModifyrecord(const ProinspectDTO::Wrapper& dto)
{
	//// 定义返回数据对象
	//auto jvo = Uint64JsonVO::createShared();
	//// 参数校验
	//if (!dto->record_id || !dto->record_id < 0)
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}
	//// 定义一个Service
	//ProinspectService service;
	//// 执行数据修改
	//if (service.updateData(dto)) {
	//	jvo->success(dto->record_id);
	//}
	//else
	//{
	//	jvo->fail(dto->record_id);
	//}
	//// 响应结果
	//return jvo;
	return {};
}

Uint64JsonVO::Wrapper  ProinspectController::execRemoverecord(const UInt64& record_id) {


	//// 定义返回数据对象
	//auto jvo = Uint64JsonVO::createShared();
	//// 参数校验
	//if (!record_id || record_id <= 0)
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}
	//// 定义一个Service
	//ProinspectService service;
	//// 执行数据删除
	//if (service.removeData(record_id.getValue(0))) {
	//	jvo->success(record_id);
	//}
	//else
	//{
	//	jvo->fail(record_id);
	//}
	//// 响应结果
	//return jvo;
	return {};
}

ProinspectPageJsonVO::Wrapper ProinspectController::execQueryProcessInspectionList(const ProinspectQuery::Wrapper& query, const PayloadDTO& payload)
{
	return ProinspectPageJsonVO::Wrapper();
}

ProinspectPageJsonVO::Wrapper ProinspectController::execQueryProcessInspectionDefectList(const ProinspectQuery::Wrapper& query, const PayloadDTO& payload)
{
	return ProinspectPageJsonVO::Wrapper();
}

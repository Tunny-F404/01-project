#include "stdafx.h"
#include "DefectController.h"
#include "../../service/defect/QcDefectService.h"

// 1 获取缺陷列表（条件+分页）
DefectPageJsonVO::Wrapper DefectController::execQueryDefect(const QcDefectQuery::Wrapper& query, const PayloadDTO& payload)
{
	// 定义一个Service
	DefectService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = DefectPageJsonVO::createShared();
	jvo->success(result);
	return jvo;
}
// 2 添加缺陷
Uint64JsonVO::Wrapper DefectController::execAddDefect(const DefectDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	// 非空校验
	if (!dto->defect_code || !dto->defect_name || !dto->index_type || !dto->defect_level)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 有效值校验
	if (dto->defect_code->empty() || dto->defect_name->empty() || dto->index_type->empty() || dto->defect_level->empty())
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}

	// 定义一个Service
	DefectService service;
	// 执行数据新增
	uint64_t id = service.insert(dto);
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
// 3 修改缺陷
Uint64JsonVO::Wrapper DefectController::execModifyDefect(const DefectUpdateDTO::Wrapper& dto)
{
	return {};
}
// 4 删除缺陷
Uint64JsonVO::Wrapper DefectController::execRemoveDefect(const String& removeList)
{
	return {};
}
// 5 导出缺陷
std::shared_ptr<oatpp::web::server::api::ApiController::OutgoingResponse>
DefectController::execExportDefect(std::shared_ptr<oatpp::web::server::api::ApiController::IncomingRequest> request)
{
	return createResponse(Status::CODE_200, "export defect file content");
}
#include "stdafx.h"
#include "DefectController.h"

// 1 获取缺陷列表（条件+分页）
DefectPageJsonVO::Wrapper DefectController::execQueryDefect(const DefectQuery::Wrapper& query, const PayloadDTO& payload)
{
	auto jvo = DefectPageJsonVO::createShared();
	return jvo;
}
// 2 添加缺陷
Uint64JsonVO::Wrapper DefectController::execAddDefect(const DefectDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
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
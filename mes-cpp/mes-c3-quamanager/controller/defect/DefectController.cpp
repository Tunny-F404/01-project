#include "stdafx.h"
#include "DefectController.h"

DefectPageJsonVO::Wrapper DefectController::execQueryDefect(const DefectQuery::Wrapper& query, const PayloadDTO& payload)
{
	auto jvo = DefectPageJsonVO::createShared();
	return jvo;
}
// 3.3 新增数据
Uint64JsonVO::Wrapper DefectController::execAddDefect(const DefectDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}
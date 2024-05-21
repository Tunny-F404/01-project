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
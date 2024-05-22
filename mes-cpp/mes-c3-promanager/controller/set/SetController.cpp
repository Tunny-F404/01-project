#include "stdafx.h"
#include "SetController.h"


// 1 导出文件
StringJsonVO::Wrapper SetController::execProcessExport(const ProcessExportQuery::Wrapper& query)
{
	return {};
}
// 2 添加工艺
Uint64JsonVO::Wrapper SetController::execAddSet(const SetProAddTableDTO::Wrapper& dto)
{
	return {};
}
// 3 修改工艺
Uint64JsonVO::Wrapper SetController::execModifySet(const SetProAddTableDTO::Wrapper& dto)
{
	return {};
}
// 4 获取工艺步骤列表
SetProListPageJsonVO::Wrapper SetController::execQuerySet(const SetProListQuery::Wrapper& query, const PayloadDTO& payload) {
	return {};
}
// 5 添加工序步骤
Uint64JsonVO::Wrapper SetController::execAddStepSet(const SetProListDTO::Wrapper& dto)
{
	return {};
}
// 6 获取工序列表
ProListJsonVO::Wrapper SetController::execQueryProList(const ProListQuery::Wrapper& query)
{
	return ProListJsonVO::Wrapper();
}
// 7 获取工序名称列表
ProListJsonVO::Wrapper SetController::execQueryProNameList()
{
	return ProListJsonVO::Wrapper();
}
// 8 获取工序详情
ProDetailJsonVO::Wrapper SetController::execQueryProDetail(const ProDetailQuery::Wrapper& query)
{
	return ProDetailJsonVO::Wrapper();
}
// 9 修改工序步骤
Uint64JsonVO::Wrapper SetController::execModifyStepSet(const SetProListDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}
// 10 删除工序步骤
Uint64JsonVO::Wrapper SetController::execDeleteStepSet(const SetProListDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}
// 11 导出工序步骤
StringJsonVO::Wrapper SetController::execExportStepSet(const SetStepExportQuery::Wrapper& dto)
{
	return StringJsonVO::Wrapper();
}
// 12 删除工序
Uint64JsonVO::Wrapper SetController::execDeleteSet(const SetProAddTableDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}
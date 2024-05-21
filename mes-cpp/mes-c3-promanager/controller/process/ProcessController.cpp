#include "stdafx.h"
#include "ProcessController.h"

//1 查询工艺列表
ProcessListJsonVO::Wrapper ProcessController::execQueryProcessList(const ProcessListQuery::Wrapper& query)
{
	return {};
}

//2 查询工艺详情
ProcessDetailJsonVO::Wrapper ProcessController::execQueryProcessDetail(const ProcessDetailQuery::Wrapper& query)
{
	return {};
}

//3 新增工艺数据
Uint64JsonVO::Wrapper ProcessController::execAddProcess(const ProcessAddDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();

	//响应结果
	return jvo;
}
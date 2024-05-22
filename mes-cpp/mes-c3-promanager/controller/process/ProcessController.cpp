#include "stdafx.h"
#include "ProcessController.h"

// 1 查询工艺列表
ProcessListJsonVO::Wrapper ProcessController::execQueryProcessList(const ProcessListQuery::Wrapper& query)
{
	return {};
}

// 2 查询工艺详情
ProcessDetailJsonVO::Wrapper ProcessController::execQueryProcessDetail(const ProcessDetailQuery::Wrapper& query)
{
	return {};
}

// 3 添加工艺
Uint64JsonVO::Wrapper ProcessController::execAddProcess(const ProcessAddDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}

// 4 修改工艺
Uint64JsonVO::Wrapper ProcessController::execModifyBasicProcess(const ProcessAddDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}

// 5 获取工艺关联产品列表（条件+分页）
ProductsPageJsonVO::Wrapper ProcessController::execQueryProducts(const ProcessProductsQuery::Wrapper& query)
{
	return {};
}

// 6 删除工艺
Uint64JsonVO::Wrapper ProcessController::execRemoveProcess(const List<UInt64>& id)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}

//7 工艺导出
StringJsonVO::Wrapper ProcessController::execQueryProcess(const ProcessQuery::Wrapper& query)
{
	auto jvo = StringJsonVO::createShared();
	return jvo;
}
//8 获取组成工序列表
ProJsonVO::Wrapper ProcessController::execProTable(const ProQuery::Wrapper& query)
{
	return ProJsonVO::Wrapper();
}
//9 添加组成工序
Uint64JsonVO::Wrapper ProcessController::execaddComProcess(const NewProcessDTO::Wrapper& dto)
{
	return {};
}
//10 修改组成工序
Uint64JsonVO::Wrapper ProcessController::execModifyProcess(const ModifyProDTO::Wrapper& dto)
{
	return {};
}
#include "stdafx.h"
#include "MachineryPlanQueryController.h"
#include "../../service/query-ForeverOMC/MachineryPlanService.h"

MachineryListPageJsonVO::Wrapper MachineryPlanQueryController::execQueryMachineryList(const MachineryListQuery::Wrapper& query)
{
	return {};
}

MachineryPlanPageJsonVO::Wrapper MachineryPlanQueryController::execQueryMachineryPlan(const MachineryPlanQuery::Wrapper& query)
{
	// 定义一个Service
	MachineryPlanService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = MachineryPlanPageJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

MachineryPlanDetailsJsonVO::Wrapper MachineryPlanQueryController::execQueryMachineryPlanDetails(const MachineryPlanDetailsQuery::Wrapper& query)
{
	// 定义一个Service
	MachineryPlanService service;
	// 查询数据
	auto result = service.getDetails(query);
	// 响应结果
	auto jvo = MachineryPlanDetailsJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

MachinerySubjectPageJsonVO::Wrapper MachineryPlanQueryController::execQueryMachinerySubject(const MachinerySubjectQuery::Wrapper& query)
{
	return {};
}
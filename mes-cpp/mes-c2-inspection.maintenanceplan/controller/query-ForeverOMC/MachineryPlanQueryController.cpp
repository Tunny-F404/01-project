#include "stdafx.h"
#include "MachineryPlanQueryController.h"
#include "../mes-c2-inspection.maintenanceplan/service/dv_check_plan/Dv_check_planService.h"

MachineryListPageJsonVO::Wrapper MachineryPlanQueryController::execQueryMachineryList(const MachineryListQuery::Wrapper& query)
{
	MachineryListPageDTO::Wrapper a;
	auto jvo = MachineryListPageJsonVO::createShared();
	jvo -> success(a);
	return jvo;
}

MachineryPlanPageJsonVO::Wrapper MachineryPlanQueryController::execQueryMachineryPlan(const MachineryPlanQuery::Wrapper& query)
{
	//return {};
	//以上是原本内容，暂时注释，以下是abf的测试
	// 定义一个Service
	int a = 0;
	Dv_check_planService service;
	// 查询数据
	MachineryPlanPageDTO::Wrapper result = service.listAll(query);
	// 响应结果
	auto jvo = MachineryPlanPageJsonVO::createShared();
	jvo->success(result);
	return jvo;
	return {};
}

MachineryPlanDetailsJsonVO::Wrapper MachineryPlanQueryController::execQueryMachineryPlanDetails(const MachineryPlanDetailsQuery::Wrapper& query)
{
	return {};
}

MachinerySubjectPageJsonVO::Wrapper MachineryPlanQueryController::execQueryMachinerySubject(const MachinerySubjectQuery::Wrapper& query)
{
	return {};
}
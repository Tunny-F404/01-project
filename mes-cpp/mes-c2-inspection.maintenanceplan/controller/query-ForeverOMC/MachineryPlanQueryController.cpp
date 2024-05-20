#include "stdafx.h"
#include "MachineryPlanQueryController.h"

MachineryListPageJsonVO::Wrapper MachineryPlanQueryController::execQueryMachineryList(const MachineryListQuery::Wrapper& query)
{
	MachineryListPageDTO::Wrapper a;
	auto jvo = MachineryListPageJsonVO::createShared();
	jvo -> success(a);
	return jvo;
}

MachineryPlanPageJsonVO::Wrapper MachineryPlanQueryController::execQueryMachineryPlan(const MachineryPlanQuery::Wrapper& query)
{
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
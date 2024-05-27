#include "stdafx.h"
#include "DeletePlanSubjectController.h"
//扩查询来辅助
#include "../mes-c2-inspection.maintenanceplan/service/dv_check_plan/Dv_check_planService.h"

BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeletePlanMachiner(const DeleteMachinerDTO::Wrapper& dto)
{
	return BooleanJsonVO::Wrapper();
}

BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeletePlanSubject(const DeleteSubjectDTO::Wrapper& dto)
{
	return BooleanJsonVO::Wrapper();
}

BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeletePlan(const DeletePlanDTO::Wrapper& dto)
{
	return {};
}

DeletePlanQueryJsonVO::Wrapper DeletePlanSubjectController::execDeletePlanQuery(const DeletePlanQuery::Wrapper& query)
{
	int a = 0;
	Dv_check_planService service;
	// 查询数据
	DeletePlanQueryDTO::Wrapper result = service.listAll(query);
	// 响应结果
	auto jvo = DeletePlanQueryJsonVO::createShared();
	jvo->success(result);
	return jvo;

	//return DeletePlanQueryJsonVO::Wrapper();
	return {};
}





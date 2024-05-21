#include "stdafx.h"
#include "DeletePlanSubject.h"

BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeletePlanSubject(const DeletePlanSubjectDTO::Wrapper& dto)
{
	auto res = BooleanJsonVO::createShared();
	
	res->success(true);
	return res;

	//return BooleanJsonVO::Wrapper();
}

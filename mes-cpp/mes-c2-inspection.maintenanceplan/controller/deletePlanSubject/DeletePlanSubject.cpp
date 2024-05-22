#include "stdafx.h"
#include "DeletePlanSubject.h"

BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeletePlanSubject(const DeletePlanSubjectDTO::Wrapper& dto)
{
	auto res = BooleanJsonVO::createShared();
	
	res->success(true);
	return res;

	//return BooleanJsonVO::Wrapper();
}

BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeletePlanSubjectOneToMany(const DeletePlanSubjectOneToManyDTO::Wrapper& dto)
{
	auto res = BooleanJsonVO::createShared();

	res->success(true);
	return res;

	//return BooleanJsonVO::Wrapper();
}
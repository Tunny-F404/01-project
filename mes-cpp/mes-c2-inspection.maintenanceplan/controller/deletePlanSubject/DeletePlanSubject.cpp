#include "stdafx.h"
#include "DeletePlanSubject.h"
/*
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
*/

/*
BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeleteUnique(const DeleteTableUniqueDTO::Wrapper& dto)
{
	return BooleanJsonVO::Wrapper();
}

BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeleteShared(const DeleteTableSharedDTO::Wrapper& dto)
{
	return BooleanJsonVO::Wrapper();
}

*/
BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeletePlanMachiner(const DeleteMachinerDTO::Wrapper& dto)
{
	return BooleanJsonVO::Wrapper();
}

BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeletePlanSubject(const DeleteSubjectDTO::Wrapper& dto)
{
	return BooleanJsonVO::Wrapper();
}

BooleanJsonVO::Wrapper DeletePlanSubjectController::execDeletePlan(const DeletePlanTDO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = BooleanJsonVO::createShared();
	// 参数校验
	/*
	UInt64 id;
	if (!id || id <= 0)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	*/

	auto abf = (dto->item);
	auto abf1 = abf.get();
	auto abf2 = abf->begin();

	auto abf11 = *(abf1->begin());
	for (std::list<oatpp::UInt64>::iterator it = abf1->begin(); it != abf1->end(); ++it) {
		std::cout << *it << " ";//此处的*it大概能被当做id去使用

	}
	//return BooleanJsonVO::Wrapper();
	return jvo;
}

#include "stdafx.h"
#include "HumanResourceListController.h"

HumanResourceListPageVO::Wrapper HumanResourceListController::execQueryHumanResourceList(const HumanResourceListQuery::Wrapper& query)
{
	return HumanResourceListPageVO::Wrapper();
}

Uint64JsonVO::Wrapper HumanResourceListController::execAddHumanResourceList(const HumanResourceListDTO::Wrapper& dto)
{
	return Uint64JsonVO::Wrapper();
	//return {};
}

Uint64JsonVO::Wrapper HumanResourceListController::execModifyHumanResource(const HumanResourceModifyDTO::Wrapper& dto)
{
	return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper HumanResourceListController::execRemoveHumanResource(const UInt64& id)
{
	return Uint64JsonVO::Wrapper();
}

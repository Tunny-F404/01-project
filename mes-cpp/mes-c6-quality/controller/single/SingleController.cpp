#include "stdafx.h"
#include "SingleController.h"
#include "../../service/single/SingleService.h"
#include "../ApiDeclarativeServicesHelper.h"

SamplePageJsonVO::Wrapper SingleController::execQuerySingle(const SingleQuery::Wrapper& query, const PayloadDTO& payload)
{
	return{};
}

Uint64JsonVO::Wrapper SingleController::execAddSample(const SampleDTO::Wrapper& dto)
{
	return{};
}

Uint64JsonVO::Wrapper SingleController::execModifySample(const SampleDTO::Wrapper& dto)
{
	return{};
}

Uint64JsonVO::Wrapper SingleController::execRemoveSample(const UInt64& id)
{
	return{};
}


SamplePageJsonVO::Wrapper SingleController::execQueryAll(const SampleQuery::Wrapper& query, const PayloadDTO& payload)
{
	return{};
}

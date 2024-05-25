#include "stdafx.h"
#include "WorkFixtureController.h"

WorkFixtureJsonVO::Wrapper WorkFixtureController::execQueryWorkFixtureTable(const WorkFixtureQuery::Wrapper &query)
{
	return {};
}

WorkFixtureDetailJsonVO::Wrapper WorkFixtureController::execQueryWorkFixtureDetail(const UInt64 id)
{
	return {};
}

Uint64JsonVO::Wrapper WorkFixtureController::execAddWorkFixture(const WorkFixtureDetailDTO::Wrapper &dto)
{
	return {};
}

Uint64JsonVO::Wrapper WorkFixtureController::execModifyWorkFixture(const WorkFixtureDetailDTO::Wrapper &dto)
{
	return {};
}

Uint64JsonVO::Wrapper WorkFixtureController::execRemoveWorkFixture(const List<UInt64> &id)
{
	return {};
}

StringJsonVO::Wrapper WorkFixtureController::execExportWorkFixture(const WorkFixtureQuery::Wrapper &query)
{
	return {};
}

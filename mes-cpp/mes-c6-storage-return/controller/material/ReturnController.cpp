#include "stdafx.h"
#include "ReturnController.h"

GetReturnListPageJsonVO::Wrapper ReturnController::execQueryList(const GetReturnListQuery::Wrapper& query)
{
	return GetReturnListPageJsonVO::Wrapper();
}

Uint64JsonVO::Wrapper ReturnController::execAddReturnLine(const AddReturnDTO::Wrapper& dto)
{
	return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper ReturnController::execModifyReturnline(const AddReturnDTO::Wrapper& dto)
{
	return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper ReturnController::execRemoveReturnline(const UInt64& lineid)
{
	return Uint64JsonVO::Wrapper();
}

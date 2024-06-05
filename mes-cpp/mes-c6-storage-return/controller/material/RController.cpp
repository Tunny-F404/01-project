#include "stdafx.h"
#include "RController.h"

GetReturnListPageJsonVO::Wrapper RController::execQueryList(const GetReturnListQuery::Wrapper& query)
{
	return GetReturnListPageJsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RController::execAddReturnLine(const AddReturnDTO::Wrapper& dto)
{
	return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RController::execModifyReturnline(const AddReturnDTO::Wrapper& dto)
{
	return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RController::execRemoveReturnline(const UInt64& lineid)
{
	return Uint64JsonVO::Wrapper();
}

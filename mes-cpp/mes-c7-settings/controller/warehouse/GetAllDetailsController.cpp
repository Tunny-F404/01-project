#include "stdafx.h"
#include "GetAllDetailsController.h"

GetAllDetailsJsonVO::Wrapper GetAllDetailsController::execQueryGetAllDetails(const GetAllDetailsQuery::Wrapper& query, const PayloadDTO& payload)
{
	auto jvo = GetAllDetailsJsonVO::createShared();
	return jvo;
}
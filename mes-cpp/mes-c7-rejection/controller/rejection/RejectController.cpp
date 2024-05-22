#include "stdafx.h"
#include "RejectController.h"
#include "domain/vo/BaseJsonVO.h"
#include "domain\dto\PayloadDTO.h"

RejectPageJsonVO::Wrapper RejectController::execQueryReject(const RejectQuery::Wrapper& query, const PayloadDTO& payload)
{

	return {};
}

RejectPageJsonVO::Wrapper RejectController::execQueryRejectDetail(const RejectQuery::Wrapper& query)
{

	return {};
}
Uint64JsonVO::Wrapper RejectController::execAddReject(const RejectDetailDTO::Wrapper& dto)
{
	return {};
}

Uint64JsonVO::Wrapper RejectController::execModifyReject(const RejectDetailDTO::Wrapper& dto)
{
	return {};
}

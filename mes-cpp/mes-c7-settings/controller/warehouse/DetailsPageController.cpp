#include "stdafx.h"
#include "DetailsPageController.h"

DetailsPageJsonVO::Wrapper DetailsPageController::execQueryDetailsPage(const DetailsPageQuery::Wrapper& query, const PayloadDTO& payload)
{
	auto jvo = DetailsPageJsonVO::createShared();

	return jvo;
}
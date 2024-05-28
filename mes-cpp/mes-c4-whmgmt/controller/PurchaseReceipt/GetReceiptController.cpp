#pragma once

#include "stdafx.h"
#include "GetReceiptController.h"
#include "../../service/Receipt/ReceiptService.h"
#include "../ApiDeclarativeServicesHelper.h"

ReceiptPageTableJsonVO::Wrapper GetReceiptController::execQueryReceiptPageTable(const ReceiptTableQuery::Wrapper& query)
{
	ReceiptService service;

	auto result = service.listAll(query);
	auto jvo = ReceiptPageTableJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

ReceiptDetailJsonVO::Wrapper GetReceiptController::execQueryReceiptDetail(const ReceiptDetailQuery::Wrapper& query)
{
	std::cout << "Get Query Receipt Detail success hahahahaha" << std::endl;
	return {};
}

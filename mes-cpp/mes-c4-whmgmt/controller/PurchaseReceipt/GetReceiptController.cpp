#pragma once

#include "stdafx.h"
#include "GetReceiptController.h"

ReceiptPageTableJsonVO::Wrapper GetReceiptController::execQueryReceiptPageTable(const ReceiptTableQuery::Wrapper& query)
{
	std::cout << "Get Query Receipt Page Table success hahahahaha" << std::endl;
	return {};
}

ReceiptDetailJsonVO::Wrapper GetReceiptController::execQueryReceiptDetail(const ReceiptDetailQuery::Wrapper& query)
{
	std::cout << "Get Query Receipt Detail success hahahahaha" << std::endl;
	return {};
}

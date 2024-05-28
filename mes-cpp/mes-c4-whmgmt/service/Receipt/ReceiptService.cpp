#include "stdafx.h"
#include "ReceiptService.h"
#include "../../dao/Receipt/ReceiptDAO.h"
#include "../../domain/do/Receipt/ReceiptDO.h"
#include <list>

ReceiptPageTableDTO::Wrapper ReceiptService::listAll(const ReceiptTableQuery::Wrapper& query)
{
	auto pages = ReceiptPageTableDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	ReceiptPageTableDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0) {
		return pages;
	}

	pages->total = count;
	pages->calcPages();
	std::list<ReceiptPageTableDO> result = dao.selectWithPage(query);

	// ½«DO×ª»»³ÉDTO
	for (ReceiptPageTableDO sub : result)
	{
		auto dto = ReceiptDTO::createShared();

		dto->recptId = sub.getRecptId(); 
		dto->recptCode = sub.getRecptCode(); 
		dto->recptName = sub.getRecptName(); 
		dto->vendorName = sub.getVendorName(); 
		dto->poCode = sub.getPoCode(); 
		dto->recptDate = sub.getRecptDate(); 
		dto->status = sub.getStatus();

		pages->addData(dto);

	}

	return pages;
}

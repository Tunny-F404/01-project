#include "stdafx.h"
#include "IncomingService.h
#include"../../dao/incoming/IncomingDAO.h"

IncomingPageDTO::Wrapper IncomingService::listAll(const IncomingQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = IncomingPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// 查询数据总条数
	IncomingDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<IncomingDO> result = dao.selectWithPage(query);
	// 将DO转换成DTO
	for (IncomingDO sub : result)
	{
		auto dto = IncomingDTO::createShared();
		
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, iqcCode, IqcCode, vendorCode, VendorCode, vendorName, VendorName, vendorBatch, VendorBatch)
			pages->addData(dto);

	}
	return pages;
}
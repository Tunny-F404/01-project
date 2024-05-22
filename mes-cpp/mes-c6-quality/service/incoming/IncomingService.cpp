#include "stdafx.h"
#include "IncomingService.h"
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
		
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, incomingCode, IncomingCode, vendorCode, VendorCode, vendorName, VendorName, vendorBatch, VendorBatch)
			pages->addData(dto);

	}
	return pages;
}

uint64_t IncomingService::saveData(const IncomingDTO::Wrapper& dto)
{
	// 组装DO数据
	IncomingDO data;

	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, IncomingCode, incomingCode, VendorCode, vendorCode, VendorName, vendorName,
		VendorBatch, vendorBatch);
		// 执行数据添加
		IncomingDAO dao;
	return dao.insert(data);
}

bool IncomingService::updateData(const IncomingDTO::Wrapper& dto)
{
	// 组装DO数据
	IncomingDO data;
	
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, IncomingCode, incomingCode, VendorCode, vendorCode, VendorName, vendorName,
		VendorBatch, vendorBatch);		
	// 执行数据修改
	IncomingDAO dao;
	return dao.update(data) == 1;
}

bool IncomingService::removeData(string iqc_code)
{
	IncomingDAO dao;
	return dao.deleteByIcCode(iqc_code) == 1;
}
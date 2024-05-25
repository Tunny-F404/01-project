#include "stdafx.h"
#include "ProductService.h"
#include "../../dao/product/ProductDAO.h"

ProductPageDTO::Wrapper ProductTableService::listAll(const ProductQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = ProductPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// 查询数据总条数
	ProductTableDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<ProductTableDO> result = dao.selectWithPage(query);
	// 将DO转换成DTO
	for (ProductTableDO sub : result)
	{
		auto dto = ProductTableDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, pid, Pid, pnum, Pnum, pname, Pname, plist, Plist, pcnum, Pcnum, pcname, Pcname, pdate, Pdate, pstatus, Pstatus)
			pages->addData(dto);
	}
	return pages;
}

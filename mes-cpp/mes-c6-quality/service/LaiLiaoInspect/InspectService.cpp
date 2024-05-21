#include "stdafx.h"
#include "InspectService.h"
#include "../../dao/LaiLiaoInspect/InspectDAO.h"

InspectPageDTO::Wrapper InspectService::listAll(const InspectQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = InspectPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// 查询数据总条数
	InspectDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<InspectDO> result = dao.selectWithPage(query);
	// 将DO转换成DTO
	for (InspectDO sub : result)
	{
		auto dto = InspectDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, line_id, Line_id, issue_id, Issue_id, item_id, Item_id, item_code, Item_code, item_name, Item_name, specification, Specification, unit_of_measure, Unit_of_measure, quantity_issued, Quantity_issued, batch_code, Batch_code, warehouse_name, Warehouse_name, location_name, Location_name, area_name, Area_name, remark, Remark)
			pages->addData(dto);
	}
	return pages;
}

uint64_t InspectService::saveData(const InspectDTO::Wrapper& dto)
{
	// 组装DO数据
	InspectDO data;
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Issue_id, issue_id, Item_id, item_id, Item_code, item_code, Item_name, item_name, Specification, specification, Unit_of_measure, unit_of_measure, Quantity_issued, quantity_issued, Batch_code, batch_code, Warehouse_name, warehouse_name, Location_name, location_name, Area_name, area_name, Remark, remark)
		// 执行数据添加
		InspectDAO dao;
	return dao.insert(data);
}

bool InspectService::updateData(const InspectDTO::Wrapper& dto)
{
	// 组装DO数据
	InspectDO data;
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Issue_id, issue_id, Item_id, item_id, Item_code, item_code, Item_name, item_name, Specification, specification, Unit_of_measure, unit_of_measure, Quantity_issued, quantity_issued, Batch_code, batch_code, Warehouse_name, warehouse_name, Location_name, location_name, Area_name, area_name, Remark, remark, Line_id, line_id)
		// 执行数据修改
		InspectDAO dao;
	return dao.update(data) == 1;
}

bool InspectService::removeData(uint64_t id)
{
	InspectDAO dao;
	return dao.deleteById(id) == 1;
}
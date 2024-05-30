#include "stdafx.h"
#include "InspectService.h"
#include "../../dao/LaiLiaoInspect/InspectDAO.h"
#include "../../domain/do/LaiLiaoInspect/InspectDO.h"

//查询来料检验列表
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
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, line_id, Line_id, code, Code, name, Name, template_id, Template_id, vendor_id, Vendor_id, vendor_code, Vendor_code, vendor_name, Vendor_name, vendor_nick, Vendor_nick, vendor_batch, Vendor_batch, item_code, Item_code, item_name, Item_name);
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, quantity_recived, Quantity_recived, quantity_check, Quantity_check, quantity_unqualified, Quantity_unqualified, check_result, Check_result, recive_date, Recive_date, inspect_date, Inspect_date, inspector, Inspector, list_status, List_status);
		pages->addData(dto);
	}
	return pages;
}

//查询来料检验详情
Inspect_detailDTO::Wrapper InspectService::list_detailAll(const Inspect_detailQuery::Wrapper& query)
{
	// 构建返回对象
	auto one = Inspect_detailDTO::createShared();


	// 查询数据总条数
	Inspect_detailDAO dao;
	list<Inspect_detailDO> result = dao.selectWithID(query);
	// 将DO转换成DTO
	for (Inspect_detailDO sub : result)
	{
		auto dto = Inspect_detailDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, line_id, Line_id, code, Code, name, Name, template_id, Template_id, vendor_id, Vendor_id, vendor_code, Vendor_code, vendor_name, Vendor_name, vd_nick, Vd_nick, vd_batch, Vd_batch, item_code, Item_code, item_name, Item_name, quantity_recived, Quantity_recived, quantity_check, Quantity_check, quantity_unqualified, Quantity_unqualified, check_result, Check_result, recive_date, Recive_date, inspect_date, Inspect_date, inspector, Inspector, list_status, List_status)
			one->addData(dto);
	}
	return one;
}

uint64_t InspectService::saveData(const InspectDTO::Wrapper& dto)
{
	// 组装DO数据
	InspectDO data;
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Code, code, Name, name, Template_id, template_id, Vendor_id, vendor_id, Vendor_code, vendor_code, Vendor_name, vendor_name, Vd_nick, vd_nick, Vd_batch, vd_batch, Item_code, item_code, Item_name, item_name, Quantity_recived, quantity_recived, Quantity_check, quantity_check, Quantity_unqualified, quantity_unqualified, Check_result, check_result, Recive_date, recive_date, Inspect_date, inspect_date, Inspector, inspector, List_status, list_status)
		// 执行数据添加
		InspectDAO dao;
	return dao.insert(data);
}

bool InspectService::updateData(const InspectDTO::Wrapper& dto)
{
	// 组装DO数据
	InspectDO data;
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Code, code, Name, name, Template_id, template_id, Vendor_id, vendor_id, Vendor_code, vendor_code, Vendor_name, vendor_name, Vd_nick, vd_nick, Vd_batch, vd_batch, Item_code, item_code, Item_name, item_name, Quantity_recived, quantity_recived, Quantity_check, quantity_check, Quantity_unqualified, quantity_unqualified, Check_result, check_result, Recive_date, recive_date, Inspect_date, inspect_date, Inspector, inspector, List_status, list_status, Line_id, line_id)
		// 执行数据修改
		InspectDAO dao;
	return dao.update(data) == 1;
}

bool InspectService::removeData(uint64_t id)
{
	InspectDAO dao;
	return dao.deleteById(id) == 1;
}
#include "stdafx.h"
#include "Single_Defect_Service.h"
#include "../../dao/Single_Defect/Single_Defect_DAO.h"
#include "../../domain/do/Single_Defect/Single_Defect_DO.h"

SinglePageDTO::Wrapper Single_Defect_Service::listAll_Index(const SingleQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = SinglePageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// 查询数据总条数
	Single_Defect_DAO dao;
	uint64_t count = dao.count_Index(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<IndexDO> result = dao.selectIndexPage(query);
	// 将DO转换成DTO
	for (IndexDO sub : result)
	{
		auto dto = SingleDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, line_id, Line_id, iqc_id, Iqc_id, index_id, Index_id, index_name, Index_name,   index_type, Index_type,  qc_tool, Qc_tool,  check_method, Check_method,  stander_val,Stander_val, unit_of_measure, Unit_of_measure, threshold_max, Threshold_max, threshold_min, Threshold_min, cr_quantity, Cr_quantity, maj_quantity, Maj_quantity, min_quantity, Min_quantity, remark, Remark);
		//ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub,  );
		pages->addData(dto);
	}
	return pages;
}

DefectPageDTO::Wrapper Single_Defect_Service::listAll_Defect(const DefectQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = DefectPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// 查询数据总条数
	Single_Defect_DAO dao;
	uint64_t count = dao.count_Defect(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<DefectDO> result = dao.selectDefectPage(query);
	// 将DO转换成DTO
	for (DefectDO sub : result)
	{
		auto dto = DefectDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, record_id, Record_id, qc_type, Qc_type, qc_id, Qc_id, line_id, Line_id, defect_name, Defect_name, defect_level, Defect_level, defect_quantity, Defect_quantity, remark, Remark);
		pages->addData(dto);
	}
	return pages;
}

uint64_t Single_Defect_Service::saveData(const DefectDTO::Wrapper& dto)
{
	return {};
}

bool Single_Defect_Service::updateData(const DefectDTO::Wrapper& dto)
{
	return {};
}

bool Single_Defect_Service::removeData(uint64_t id)
{
	return {};
}
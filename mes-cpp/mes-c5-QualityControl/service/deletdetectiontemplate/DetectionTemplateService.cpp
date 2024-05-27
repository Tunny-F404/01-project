#include "stdafx.h"
#include "DetectionTemplateService.h"
#include "../../dao/detectiontemplate/DetectionTemplateDAO.h"
#include "../../domain/dto/detectiontemplate/DetectionTemplateDTO.h"
#include "../../domain/do/DetectionTemplate/DetectionTemplateDO.h"

bool DetectionTemplateService::RemoveDetectionTemplateData(uint64_t template_id)
{
	DetectionTemplateDAO dao;
	return dao.deleteBydetectiontemplateId(template_id) == 1;
	return true;
}

DetectionTemplatePageDTO::Wrapper DetectionTemplateService::listAllTemplateList(const DetectionTemplateQuery::Wrapper& query) {
	//// 构建返回对象
	//auto pages = DetectionTemplatePageDTO::createShared();
	//pages->pageIndex = query->pageIndex;
	//pages->pageSize = query->pageSize;

	//// 查询数据总条数
	//DetectionTemplateDAO dao;
	//uint64_t count = dao.count(query);
	//if (count <= 0) {
	//	return pages;
	//}

	//// 分页查询数据
	//pages->total = count;
	//pages->calcPages();
	//list<DetectionTemplateDO> result = dao.selectTemplateListWithPage(query);
	//// 将DO转换成DTO
	//for (DetectionTemplateDO sub : result) {
	//	auto dto = DetectionTemplateDTO::createShared();
	//	ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, template_id, tId, template_code, tCode, template_name, tName, qc_types, tTypes, enable_flag, tEnFlag);
	//	pages->addData(dto);
	//}
	//return pages;
	return {};
}

uint64_t DetectionTemplateService::saveData(const DetectionTemplateDTO::Wrapper& dto)
{
	//// 组装DO数据
	//DetectionTemplateDO data;
	//	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Template_Id, template_id, Template_Code, template_code, Template_Name, template_name)
	//	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Qc_Types, qc_types)
	//	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Enable_Flag, enable_flag, Remark, remark)
	//	// 执行数据添加
	//	DetectionTemplateDAO dao;
	//return dao.insert(data);
	return {};
}
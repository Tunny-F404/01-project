#include "stdafx.h"
#include "DetectionItemSettingsService.h"
#include "../../dao/detectionitemsetting/DetectionItemSettingsDAO.h"


DetectionItemSettingsPageDTO::Wrapper DetectionItemSettingsService::listAll(const DetectionItemSettingsQuery::Wrapper& query)
{
	auto pages = DetectionItemSettingsPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	DetectionItemSettingsDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)	return pages;
	pages->total = count;
	pages->calcPages();
	list<DetectionItemSettingsDO> res = dao.selectWithPage(query);

	for (DetectionItemSettingsDO sub : res) {
		auto dto = DetectionItemSettingsDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, id, Id, code, Code, name, Name, type, Type, tool, Tool, remark, Remark);
		pages->addData(dto);
	}
	return pages;
}

uint64_t DetectionItemSettingsService::saveData(const DetectionItemSettingsDTO::Wrapper& dto)
{
	DetectionItemSettingsDO data;
	ZO_STAR_DOMAIN_DTO_TO_DO(data,dto, Id, id, Code, code, Name, name, Type, type, Tool, tool, Remark, remark);
	DetectionItemSettingsDAO dao;
	return dao.insert(data);
}

bool DetectionItemSettingsService::updateData(const DetectionItemSettingsDTO::Wrapper& dto)
{
	DetectionItemSettingsDO data;
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Id, id, Code, code, Name, name, Type, type, Tool, tool, Remark, remark);
	DetectionItemSettingsDAO dao;
	return dao.update(data) == 1;
}

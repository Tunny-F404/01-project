#pragma once
#ifndef _DETECTIONITEMSETTINGS_DAO_
#define	_DETECTIONITEMSETTINGS_DAO_

#include "BaseDAO.h"
#include "../../domain/do/detectionitemsettings/DetectionItemSettingsDO.h"
#include "../../domain/query/detectionitemsettings/DetectionItemSettingsQuery.h"

class DetectionItemSettingsDAO : public BaseDAO
{
public:
	uint64_t count(const DetectionItemSettingsQuery::Wrapper& query);
	list<DetectionItemSettingsDO> selectWithPage(const DetectionItemSettingsQuery::Wrapper& query);
	uint64_t insert(const DetectionItemSettingsDO& iobj);
	int update(const DetectionItemSettingsDO& uobj);
};

#endif // !_DETECTIONITEMSETTINGS_DAO_

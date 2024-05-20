#include "stdafx.h"
#include "DetectionitemsettingsContorller.h"
#include "../../service/detectionitemsettingsService/DetectionItemSettingsService.h"
#include "../ApiDeclarativeServicesHelper.h"

DetectionItemSettingsPageJsonVO::Wrapper DetectionItemSettingsController::execQueryqc(const DetectionItemSettingsQuery::Wrapper& query) {
	DetectionItemSettingsService service;
	auto res = service.listAll(query);
	auto jvo = DetectionItemSettingsPageJsonVO::createShared();
	jvo->success(res);
	return jvo;
}

Uint64JsonVO::Wrapper DetectionItemSettingsController::execAddqc(const DetectionItemSettingsDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	if (!dto->code || !dto->name || !dto->type || !dto->tool) {
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	if (dto->code->empty() || dto->name->empty() || dto->type->empty() || dto->tool->empty()) {
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	DetectionItemSettingsService service;
	uint64_t id = service.saveData(dto);
	if (id >= 0) {
		jvo->success(UInt64(id));
	}
	else {
		jvo->fail(UInt64(id));
	}
	return jvo;
}

Uint64JsonVO::Wrapper DetectionItemSettingsController::execModifyqc(const DetectionItemSettingsDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	if (dto->code->empty() || dto->name->empty() || dto->type->empty() || dto->tool->empty()) {
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	DetectionItemSettingsService service;
	if (service.updateData(dto)) {
		jvo->success(dto->id);
	}
	else {
		jvo->fail(dto->id);
	}
	return jvo;
}

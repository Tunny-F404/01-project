#include "stdafx.h"
#include "DetectionItemSettingsController.h"
#include "../ApiDeclarativeServicesHelper.h"
#include "../../service/detectionitemsettings/DetectionItemSettingsService.h"
DetectionItemSettingsPageJsonVO::Wrapper DetectionItemSettingsController::execQueryqc(const DetectionItemSettingsQuery::Wrapper& query) {
	DetectionItemSettingsService service;
	auto res = service.listAll(query);
	auto jvo = DetectionItemSettingsPageJsonVO::createShared();
	jvo->success(res);
	return jvo;
	return {};
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
	return {};
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
	return{};
}

Uint64JsonVO::Wrapper DetectionItemSettingsController::execRemoveTheDetection(const oatpp::List<UInt64>& ids)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	for (list<UInt64>::iterator i = ids->begin(); i != ids->end(); i++)
	{
		UInt64 id = *i;
		// 参数校验
		if (!id || id <= 0)
		{
			jvo->init(UInt64(-1), RS_PARAMS_INVALID);
			return jvo;
		}
		// 定义一个Service
		DetectionItemSettingsService service;
		// 执行数据删除
		if (service.removeData(id.getValue(0))) {
			jvo->success(id);
		}
		else
		{
			jvo->fail(id);
		}

	}
	// 响应结果
	return jvo;

}

StringJsonVO::Wrapper DetectionItemSettingsController::execExportDetectionItemSettings(const oatpp::List<UInt64>& id)
{
	return StringJsonVO::Wrapper();
}
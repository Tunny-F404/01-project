#include "ModifyPlanStatusController.h"
#include "stdafx.h"
#include "service/MaintenancePlanStatus/ModifyPlanStatusServer.h"

ModifyPlanStatusJsonVo::Wrapper ModifyPlanStatusController::execModifyPlanStatus(const ModifyPlanStatusDto::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = ModifyPlanStatusJsonVo::createShared();
	// 参数校验
	if (!dto->id || dto->id <= 0 )
	{
		jvo->init(dto, RS_PARAMS_INVALID);
		return jvo;
	}
	// 定义一个Service
	ModifyPlanStatusService service;
	// 执行数据修改
	if (service.updateData(dto)) {
		jvo->success(dto);
	}
	else
	{
		jvo->fail(dto);
	}
	//响应结果
	return jvo;
}

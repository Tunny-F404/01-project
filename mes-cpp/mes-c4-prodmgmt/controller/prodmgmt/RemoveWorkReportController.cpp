#pragma once

#include "stdafx.h"
#include "RemoveWorkReportController.h"
#include "../../service/prodmgmt/DeleteWorkReportService.h"
#include "../ApiDeclarativeServicesHelper.h"

Uint64JsonVO::Wrapper RemoveWorkReportController::execRemoveWorkReport(const UInt64& recordId)
{
	//// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	if (!recordId || recordId <= 0)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	
	// 定义一个Service
	DeleteWorkReportService service;

	// 执行数据删除
	if (service.removeData(recordId.getValue(0))) {
		jvo->success(recordId);
	}
	else
	{
		jvo->fail(recordId);
	}
	//// 响应结果
	return jvo;
}

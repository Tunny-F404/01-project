#include "stdafx.h"
#include "ReturnController.h"
#include "service/return/ReturnService.h"
#include "../ApiDeclarativeServicesHelper.h"

ReturnPageJsonVO::Wrapper ReturnController::executeQueryAll(const ReturnQuery::Wrapper& query, const PayloadDTO& payload)
{
	/*
	// 定义一个Service
	ReturnService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = ReturnPageJsonVO::createShared();
	jvo->success(result);*/
	return {};
}

ReturnDetailJsonVO::Wrapper ReturnController::executeQueryDetail(const ReturnDetailQuery::Wrapper& returnDetailQuery)
{
	/*
	// 定义一个Service
	ReturnService service;
	// 查询数据
	auto result = service.getDetail(returnDetailQuery);
	// 响应结果
	auto jvo = ReturnPageJsonVO::createShared();
	jvo->success(result);
	*/
	return {};
}

Uint64JsonVO::Wrapper ReturnController::execAddDetail(const ReturnAdd::Wrapper& dto)
{
	/*
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	// 非空校验
	if (!dto->returnId || !dto->returnName || !dto->vendorName || !dto->returndate || !dto->status)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 有效值校验
	if (dto->returnId->empty() || dto->returnName->empty() || dto->vendorName->empty() || dto->returndate->empty())
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}

	// 定义一个Service
	ReturnService service;
	// 执行数据新增
	uint64_t id = service.saveData(dto);
	if (id > 0) {
		jvo->success(UInt64(id));
	}
	else
	{
		jvo->fail(UInt64(id));
	}
	//响应结果
	*/
	return {};
}
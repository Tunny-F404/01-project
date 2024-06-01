#include "stdafx.h"
#include "RawMaterialOpController.h"
#include "../../service/RawMaterialOpService/RawMaterialOpService.h"
#include "../ApiDeclarativeServicesHelper.h"



Uint64JsonVO::Wrapper RawMaterialOpController::execRemoveRawMaterialOp(const UInt64& id)
{
	return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RawMaterialOpController::execModifyRawMaterialOp(const RawMaterialOpDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}


RawMaterialOpPageJsonVO::Wrapper RawMaterialOpController::execQueryRawMaterialOp(const RawMaterialOpQuery::Wrapper& query, const PayloadDTO& payload)
{
	// 定义一个Service
	RawMaterialOpService service;
	// 查询数据
	auto result = service.listAll(query);
	//// 响应结果
	auto jvo = RawMaterialOpPageJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

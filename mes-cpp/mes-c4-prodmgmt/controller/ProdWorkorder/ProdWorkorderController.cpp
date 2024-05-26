#include "stdafx.h"
#include "ProdWorkorderController.h"
#include "../mes-c4-prodmgmt/service/ProdWorkorder/ProdWorkorderService.h"



AddProdWorkorderJsonVO::Wrapper ProdWorkorderController::execAddProdWorkorder(const AddProdWorkorderDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = AddProdWorkorderJsonVO::createShared();
	// 参数校验
	// 非空校验

	// 定义一个Service
	ProdWorkorderService service;
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
	return jvo;
}

GetProdWorkorderListPageJsonVO::Wrapper ProdWorkorderController::execQueryGetProdWorkorderList(const GetProdWorkorderListQuery::Wrapper& query, const PayloadDTO& payload)
{
	//// 定义一个Service
	//ProdWorkorderService service;
	//// 查询数据
	//auto result = service.listAll(query);
	//// 响应结果
	//auto jvo = GetProdWorkorderListPageJsonVO::createShared();
	//jvo->success(result);
	//return jvo;
	return {};
}

ProdWorkorderInfoJsonVO::Wrapper ProdWorkorderController::execGetProdWorkorderInfo(const ProdWorkorderInfoDTO::Wrapper& dto)
{
	// 定义一个Service
	ProdWorkorderService service;
	// 查询数据
	auto result = service.listDetail(dto);
	// 响应结果
	auto jvo = ProdWorkorderInfoJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

ProdWorkorderBomListJsonVO::Wrapper ProdWorkorderController::execGetProdWorkorderBomList(const ProdWorkorderBomListDTO::Wrapper& dto)
{
	// 定义一个Service
	ProdWorkorderService service;
	// 查询数据
	auto result = service.listBomDetail(dto);
	// 响应结果
	auto jvo = ProdWorkorderBomListJsonVO::createShared();
	jvo->success(result);
	return jvo;
}
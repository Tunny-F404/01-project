#include "stdafx.h"
#include "WarehouseManagementController.h"
//#include "../../service/warehousemanagement/WarehouseManagementService.h"
#include "../ApiDeclarativeServicesHelper.h"
#include "../../service/warehousemanagement/WarehouseManagementService.h"
#include "../../domain/vo/warehousemanagement/WarehouseManagementVO.h"

WarehouseManagementPageJsonVO::Wrapper WarehouseManagementController::execQueryWarehouseManagement(const WarehouseManagementQuery::Wrapper& query, const PayloadDTO& payloa)
{
	// 定义一个service
	WarehouseManagementService service;
	// 查询数据

	auto result = service.listAll(query);
	// 响应结果
	auto jvo = WarehouseManagementPageJsonVO::createShared();
	jvo->success(result);

	return jvo;
	return {};
}

StringJsonVO::Wrapper WarehouseManagementController::execExportWarehouseManagement(const WarehouseManagementIdQuery::Wrapper& query)
{
	auto jvo = StringJsonVO::createShared();

	// 定义一个Service
	WarehouseManagementService service;

	//创建excel文件
	string url = service.creatExcel(query);

	if (url.empty())
	{
		jvo->init(to_string(query->item_id), ResultStatus(u8"fail to export data", 9995));
	}
	else
	{
		jvo->init(to_string(query->item_id), ResultStatus(url));
	}

	return jvo;
}
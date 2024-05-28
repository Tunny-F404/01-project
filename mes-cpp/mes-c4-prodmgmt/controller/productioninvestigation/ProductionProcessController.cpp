#include "ProductionProcessController.h"
#include "../../service/productioninvestigation/ProductionProcessService.h"
ProductionProcessJsonVO::Wrapper ProductionProcessController::execQueryProcess(const ProductionProcessQuery::Wrapper& query)
{
	// 定义一个Service
	ProductionProcessService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = ProductionProcessJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

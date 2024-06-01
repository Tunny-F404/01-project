#include "GetListController.h"


GetListPageJsonVO::Wrapper GetListController::execQueryGetList(const GetListQuery::Wrapper& query, const PayloadDTO& payload)
{
	// 定义一个Service
	GetListService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = GetListPageJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

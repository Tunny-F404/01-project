#include"stdafx.h"
#include"TestController.h"

StringJsonVO::Wrapper TestController::executeGetPage(const PageQuery::Wrapper& query)
{
	auto vo = StringJsonVO::createShared();
	vo->success(String("test query"));
	return vo;
}

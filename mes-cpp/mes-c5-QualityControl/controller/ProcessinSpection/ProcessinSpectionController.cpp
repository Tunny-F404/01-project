#include "stdafx.h"
#include "ProcessinSpectionController.h"
//#include "../../service/sample/SampleService.h"
//#include "../ApiDeclarativeServicesHelper.h"
#include "../ApiDeclarativeServicesHelper.h"
#include "../../service/processinspection/ProcessInspectionService.h"
#include "../../dao/processinspection/ProcessInspectionDAO.h"

ProcessinSpectionQueryPageJsonVO::Wrapper ProcessinSpectionController::execProcessinSpection(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload)
{
	ProcessInspectionService service;
	//执行查询
	auto result = service.listAll(query);
	auto vo = ProcessinSpectionQueryPageJsonVO::createShared();
	//把QueryPageDTO装到vo中
	vo->success(result);
	return vo;
}

oatpp::List<Uint64JsonVO::Wrapper> ProcessinSpectionController::execRemoveProcessinSpection(const List<UInt64>& ids)
{
	oatpp::List<Uint64JsonVO::Wrapper> ans = oatpp::List<Uint64JsonVO::Wrapper>::createShared();
	ProcessInspectionService service;
	//查询是否每一个id都符合,符合的查询,
	for (auto i = ids->begin(); i != ids->end(); ++i) {
		auto result = Uint64JsonVO::createShared();
		auto x = (*i).getValue(0);
		//参数错误
		if (x < 0 || !x) {
			result->init(UInt64(-1), RS_PARAMS_INVALID);
		}
		else {
			//删除失败
			if (!service.remove(x)) {
				result->init(x, RS_FAIL);
			}
			else {
				//删除成功
				result->init(x, RS_SUCCESS);
			}
		}
		ans->push_back(result);
	}
	return ans;
}

StringJsonVO::Wrapper ProcessinSpectionController::execExportProcessinSpection(const oatpp::List<UInt64>& ids)
{
	return StringJsonVO::Wrapper();
}

ProcessinSpectionJsonVO::Wrapper ProcessinSpectionController::execQueryInspectionDetails(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload)
{
	//ProcessinSpectionService service;
	//auto result = service.getInspectionDetails(query);
	auto jvo = ProcessinSpectionJsonVO::createShared();
	//jvo->success(result);
	//jvo->success(String("test 1"));
	//jvo->success(1);
	return jvo;
}

Uint64JsonVO::Wrapper ProcessinSpectionController::execModifyTheProcessInspection(const ProcessinSpectionDTO::Wrapper& dto)
{
	//// 定义返回数据对象
	//auto jvo = Uint64JsonVO::createShared();
	//// 参数校验
	//if (!dto->id || dto->id <= 0)
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}
	//// 定义一个Service
	//ProcessInspectionService service;
	//// 执行数据修改
	//if (service.updateData(dto)) {
	//	jvo->success(dto->id);
	//}
	//else
	//{
	//	jvo->fail(dto->id);
	//}
	//// 响应结果
	//return jvo;
	return {};
}

ProcessinSpectionPageJsonVO::Wrapper ProcessinSpectionController::execAddProcessInspection(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload)
{
	return {};
}

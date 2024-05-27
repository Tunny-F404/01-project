#include "stdafx.h"
#include "RController.h"

GetReturnListPageJsonVO::Wrapper RController::execQueryList(const GetReturnListQuery::Wrapper& query)
{

	return GetReturnListPageJsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RController::execAddReturnLine(const AddReturnDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	// 非空校验
	if (!dto->rtcode || !dto->rtname || !dto->vendorname || !dto->rtdate)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 有效值校验
	//if (dto->age < 0 || dto->name->empty() || dto->sex->empty())
	//{
		//jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		//return jvo;
	//}
	return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RController::execModifyReturnline(const ModifyReturnDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	if (!dto->lineid || dto->lineid <= 0)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RController::execRemoveReturnline(const UInt64& lineid)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	if (!lineid || lineid <= 0)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	return Uint64JsonVO::Wrapper();
}

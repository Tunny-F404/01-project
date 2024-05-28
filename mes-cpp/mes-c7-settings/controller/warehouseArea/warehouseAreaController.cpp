/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 10:58:42

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

	  https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
#include "stdafx.h"
#include "warehouseAreaController.h"
#include "service/warehouseArea/warehouseAreaService.h"

//controller调用service来处理分页查询请求(包含第几页和每页大小)
warehouseAreaPageJsonVO::Wrapper warehouseAreaController::execQueryWarehouseArea(const WarehouseAreaQuery::Wrapper& query, const PayloadDTO& payload)
{
	//定义一个service
	warehouseAreaService service;
	//查询数据
	auto result = service.listAll(query);
	//响应结果
	auto jvo = warehouseAreaPageJsonVO::createShared();
	jvo->success(result);
	return jvo;
}
//添加库区--问题在于dto只包含area_id area_code area_name area remark,没有仓库ID(需由上一个仓库界面的调用口提供)
Uint64JsonVO::Wrapper warehouseAreaController::execAddWarehouseArea(const warehouseAreaListDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	// 非空校验:编码和名称
	if (!dto->area_code || !dto->area_name||!dto->area_id)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 有效值校验
	if (dto->area_code->empty() || dto->area_name->empty())
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}

	// 定义一个Service
	warehouseAreaService service;
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
Uint64JsonVO::Wrapper warehouseAreaController::execModifyWarehouseArea(const warehouseAreaListDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	if (!dto->area_id || dto->area_id <= 0)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 定义一个Service
	warehouseAreaService service;
	// 执行数据修改
	if (service.updateData(dto)) {
		jvo->success(dto->area_id);
	}
	else
	{
		jvo->fail(dto->area_id);
	}
	// 响应结果
	return jvo;
}
Uint64JsonVO::Wrapper warehouseAreaController::execRemoveWarehouseArea(const UInt64& id)
{
	return {};
}
/*
 Copyright Zero One Star. All rights reserved.

 @Author: 尛孩子
 @Date: 2024/5/28 10:58:42

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
#include "ProController.h"
#include "../../service/ProduceWork/ProduceWorkService.h"


/*
开发人员：尛孩子
*/
ProduceTableJsonVO::Wrapper ProController::execPworkTable(const PworkQery::Wrapper& query)
{	
	// 定义一个Service
	ProduceWorkService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = ProduceTableJsonVO::createShared();
	jvo->success(result);
	return jvo;
	return ProduceTableJsonVO::Wrapper();
}

Uint64JsonVO::Wrapper ProController::execAddtTable(const PworkTableDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	// 非空校验
	if (!dto->feedback_type || !dto->feedback_code || !dto->task_code || !dto->product_code
		|| !dto->product_name || !dto->unit_of_measure || !dto->product_spc || !dto->quantity_feedback
		|| !dto->quantity_uncheck || !dto->nick_name || !dto->record_nick || !dto->feedback_time || !dto->remark)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 有效值校验
	if (dto->feedback_type->empty() || dto->feedback_code->empty() || dto->task_code->empty() || dto->product_code->empty() ||
		dto->product_name->empty() || dto->unit_of_measure->empty() || dto->product_spc->empty() || dto->quantity_feedback->empty() ||
		dto->quantity_uncheck->empty() || dto->nick_name->empty() || dto->record_nick->empty() || dto->feedback_time->empty() || dto->remark->empty())
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}

	// 定义一个Service
	ProduceWorkService service;
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
//
Uint64JsonVO::Wrapper ProController::execModifyTable(const treansformProduceDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	
	// 参数校验
	if (   !dto->feedback_type || !dto->feedback_code || !dto->task_code || !dto->product_code
		|| !dto->product_name || !dto->unit_of_measure || !dto->product_spc || !dto->quantity_feedback
		|| !dto->quantity_uncheck || !dto->nick_name || !dto->record_nick || !dto->feedback_time || !dto->remark)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	if (dto->feedback_type->empty() || dto->feedback_code->empty() || dto->task_code->empty() || dto->product_code->empty()
		|| dto->product_name->empty() || dto->unit_of_measure->empty() || dto->product_spc->empty() || dto->quantity_feedback->empty()
		|| dto->quantity_uncheck->empty() || dto->nick_name->empty() || dto->record_nick->empty() || dto->feedback_time->empty()
		|| dto->remark->empty())
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}


	// 定义一个Service
	ProduceWorkService service;
	// 执行数据修改
	if (service.updateData(dto)) {
		jvo->success(dto->id);
	}
	else
	{
		jvo->fail(dto->id);
	}
	// 响应结果
	return jvo;
}
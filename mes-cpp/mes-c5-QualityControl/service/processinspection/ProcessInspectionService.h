#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 11:08:56

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
#ifndef _PROCESSINSPECTION_SERVICE_
#define _PROCESSINSPECTION_SERVICE_
#include "list"
#include "domain/dto/processinspection/ProcessinSpectionDTO.h"
#include "domain/query/processinspection/ProcessinSpectionQuery.h"
#include "domain/do/processinspection/processinspectionDO.h"
#include "Macros.h"
class ProcessInspectionService
{
public:
	//更新数据
	bool updateData(const ProcessinSpectionDTO::Wrapper& dto);
	//分页查询
	ProcessinSpectionQueryPageDTO::Wrapper listAll(const ProcessinSpectionQuery::Wrapper& query);
	//用id删除记录
	bool remove(uint64_t id);
	//导出表需要的数据
	list<ProcessinSpectionDO> listAllExort(const ProcessinSpectionQuery::Wrapper& query);
	// 获取过程检验单详情
	ProcessinSpectionDTO::Wrapper getInspectionDetails(const ProcessinSpectionQuery::Wrapper& query);
	// 确认检验单
	bool updateConfirmOrdersData(const ProcessinSpectionDTO::Wrapper& dto);
	// 完成检验单
	bool updateFinishOrdersData(const ProcessinSpectionDTO::Wrapper& dto);
};
#endif
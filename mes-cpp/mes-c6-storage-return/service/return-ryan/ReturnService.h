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
#ifndef _RETURN_SERVICE_
#define _RETURN_SERVICE_
#include <list>
#include "domain/vo/return-ryan/ReturnVO.h"
#include "domain/query/return-ryan/ReturnQuery.h"
#include "domain/dto/return-ryan/ReturnDTO.h"
#include "domain/do/return-ryan/ReturnDO.h"

/**
 * 示例服务实现，演示基础的示例服务实现
 */
class ReturnService
{
public:
	// 分页查询所有数据
	ReturnPageDTO::Wrapper listAll_r(const ReturnQuery_r::Wrapper& query);
	// 保存数据
	uint64_t saveData_r(const ReturnDTO::Wrapper& dto);
	// 修改数据
	bool updateData(const ReturnDTO::Wrapper& dto);
	// 通过ID删除数据
	bool removeData(uint64_t id);
	// 执行退货（修改数据状态）
	bool excuteData(uint64_t id);
	//
	list<ReturnDO>listAllExort(const ReturnQuery_r::Wrapper& query);
};

#endif // !_RETURN_SERVICE_


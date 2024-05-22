#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 11:52:32

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
#ifndef _MODIFY_PLAN_STATUS_DO_
#define _MODIFY_PLAN_STATUS_DO_
#include "../DoInclude.h"
#include "../../GlobalInclude.h"

/**
 * 示例数据库实体类
 */
class ModifyPlanStatusDo
{
	// 计划ID
	CC_SYNTHESIZE(uint64_t, id, Id);
	// 计划状态（草稿或已完成，不可修改）
	CC_SYNTHESIZE(string, status, Status);
public:
	ModifyPlanStatusDo() {
		id = 0;
		status = "";
	}
};

#endif // !_SAMPLE_DO_

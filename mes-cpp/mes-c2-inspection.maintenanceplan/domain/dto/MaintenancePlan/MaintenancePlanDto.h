﻿#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 10:59:38

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
#ifndef __MAINTENANCEDTO_H_
#define __MAINTENANCEDTO_H_
#include "../../GlobalInclude.h"


#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 示例传输对象
 */
class MaintenancePlanDto : public oatpp::DTO
{
	DTO_INIT(MaintenancePlanDto, DTO);
	//计划ID
	API_DTO_FIELD(UInt64, id, ZH_WORDS_GETTER("maintenance.fields.planid"), true, 1);
	//计划编码
	API_DTO_FIELD(String,code,ZH_WORDS_GETTER("maintenance.fields.plancode"),true,"PLAN2024518");
	//计划名称
	API_DTO_FIELD(String, name, ZH_WORDS_GETTER("maintenance.fields.planname"), true,"DEFAULT_NAME");
	//计划类型
	API_DTO_FIELD(String, type, ZH_WORDS_GETTER("maintenance.fields.plantype"), true,"DEFAULT_TYPE");
	//频率
	API_DTO_FIELD(String, circletype, ZH_WORDS_GETTER("maintenance.fields.circletype"), true,"2");
	//次数
	API_DTO_FIELD(String, circlecount, ZH_WORDS_GETTER("maintenance.fields.circlecount"), true,"1");
	//计划开始时间
	API_DTO_FIELD(String, startdate, ZH_WORDS_GETTER("maintenance.fields.startdate"), true,"2024-5-18");
	//计划结束时间
	API_DTO_FIELD(String, enddate, ZH_WORDS_GETTER("maintenance.fields.enddata"), true,"2024-5-19");
	//状态
	API_DTO_FIELD(String, status, ZH_WORDS_GETTER("maintenance.fields.status"), true,"Modifying");
	//备注
	API_DTO_FIELD(String, remark, ZH_WORDS_GETTER("maintenance.fields.remark"), true,"");

};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_DTO_
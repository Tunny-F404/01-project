#pragma once
#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 11:36:29

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
#ifndef _SAMPLE_QUERY_
#define _SAMPLE_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 获取报工详情查询
 */
class PworkQery : public PageQuery
{
	DTO_INIT(PworkQery, PageQuery);
	 
	// 报工类型
	API_DTO_FIELD_DEFAULT(String, feedback_type, ZH_WORDS_GETTER("ProduceWork.fields.feedback_type"));
	 
	// 工作站名称
	API_DTO_FIELD_DEFAULT(String, workstation_name, ZH_WORDS_GETTER("ProduceWork.fields.workstation_name"));

	// 生产工单编号
	API_DTO_FIELD_DEFAULT(String, workorder_code, ZH_WORDS_GETTER("ProduceWork.fields.workorder_code"));

	//产品物料编码
	API_DTO_FIELD_DEFAULT(String, item_code, ZH_WORDS_GETTER("ProduceWork.fields.item_code"));

	//产品物料名称
	API_DTO_FIELD_DEFAULT(String, item_name, ZH_WORDS_GETTER("ProduceWork.fields.item_name"));

	//报工人
	API_DTO_FIELD_DEFAULT(String, user_name, ZH_WORDS_GETTER("ProduceWork.fields.user_name"));

	//记录人
	API_DTO_FIELD_DEFAULT(String, record_user, ZH_WORDS_GETTER("ProduceWork.fields.record_user"));

	//状态(0正常 1停用)
	API_DTO_FIELD_DEFAULT(String, status  , ZH_WORDS_GETTER("ProduceWork.fields.status"));

};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_QUERY_
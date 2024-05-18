#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: hejianwei
 @Date: 2024/5/18 17:12:31

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
#ifndef _REPAIRLINE_QUERY_
#define _REPAIRLINE_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 维修内容分页查询对象
 */
class Repair_lineQuery : public PageQuery
{
	DTO_INIT(Repair_lineQuery, PageQuery);

	//项目名称
	API_DTO_FIELD_DEFAULT(String, projectName, ZH_WORDS_GETTER("repair_line.query.fields.projectName"));

	//故障描述
	API_DTO_FIELD_DEFAULT(String, errorInstance, ZH_WORDS_GETTER("repair_line.query.fields.errorInstance"));

	//故障描述资源
	API_DTO_FIELD_DEFAULT(String, errorSource, ZH_WORDS_GETTER("repair_line.query.fields.errorSource"));

	//维修情况
	API_DTO_FIELD_DEFAULT(String, repairStatus, ZH_WORDS_GETTER("repair_line.query.fields.repairStatus"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_REPAIRLINE_QUERY_
#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: 无名氏
 @Date: 2024/05/19 11:36:29

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
#ifndef _MATERIALINFORMATION_QUERY_
#define _MATERIALINFORMATION_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 示例分页查询对象
 */
class MaterialInformationQuery : public PageQuery
{
	DTO_INIT(MaterialInformationQuery, PageQuery);
	// 退料单编号
	DTO_FIELD(String, id);
	DTO_FIELD_INFO(id) {
		info->description = ZH_WORDS_GETTER("materialinformation.field.id");
	}
	// 生产工单
	DTO_FIELD(String, order);
	DTO_FIELD_INFO(order) {
		info->description = ZH_WORDS_GETTER("materialinformation.field.order");
	}
	// 仓库名称
	DTO_FIELD(UInt32, warehouse);
	DTO_FIELD_INFO(warehouse) {
		info->description = ZH_WORDS_GETTER("materialinformation.field.warehouse");
	}
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_MATERIALINFORMATION_QUERY_
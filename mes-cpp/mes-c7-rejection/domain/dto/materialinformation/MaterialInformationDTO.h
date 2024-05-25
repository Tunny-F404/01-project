#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: 无名氏
 @Date: 2024/05/19 10:59:38

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
#ifndef _MaterialInformation_DTO_
#define _MaterialInformation_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 生产退料物料信息传输对象
 */
class MaterialInformationDTO : public oatpp::DTO
{
	DTO_INIT(MaterialInformationDTO, DTO);
	// 退料单编号
	DTO_FIELD(String, id);
	DTO_FIELD_INFO(id) {
		info->description = ZH_WORDS_GETTER("materialinformation.field.id");
	}
	// 退料单名称
	DTO_FIELD(String, name);
	DTO_FIELD_INFO(name) {
		info->description = ZH_WORDS_GETTER("materialinformation.field.name");
	}
	// 生产工单
	DTO_FIELD(String, order);
	DTO_FIELD_INFO(order) {
		info->description = ZH_WORDS_GETTER("materialinformation.field.order");
	}
	// 接收仓库
	DTO_FIELD(String, warehouse);
	DTO_FIELD_INFO(warehouse) {
		info->description = ZH_WORDS_GETTER("materialinformation.field.warehouse");
	}
	//退料日期
	DTO_FIELD(String, date);
	DTO_FIELD_INFO(date) {
		info->description = ZH_WORDS_GETTER("materialinformation.field.date");
	}
	//备注
	DTO_FIELD(String, common);
	DTO_FIELD_INFO(common) {
		info->description = ZH_WORDS_GETTER("materialinformation.field.common");
	}

};

/**
 * 示例分页传输对象
 */
class MaterialInformationPageDTO : public PageDTO<MaterialInformationDTO::Wrapper>
{
	DTO_INIT(MaterialInformationPageDTO, PageDTO<MaterialInformationDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_MaterialInformation_DTO_
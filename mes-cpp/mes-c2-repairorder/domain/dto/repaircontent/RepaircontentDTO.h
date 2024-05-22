#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: hejianwei
 @Date: 2024/05/18 23:14

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
#ifndef _REPAIRCONTENT_DTO_
#define _REPAIRCONTENT_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 维修内容传输对象
 */
class RepaircontentDTO : public oatpp::DTO
{
	DTO_INIT(RepaircontentDTO, DTO);
	
	//唯一标识(隐藏的)
	API_DTO_FIELD(UInt64, repair_id, ZH_WORDS_GETTER("repaircontent.field.id"), true, 1);
	//项目名称
	API_DTO_FIELD(String, projectName, ZH_WORDS_GETTER("repaircontent.field.name"), true, "");
	//故障描述
	API_DTO_FIELD(String, errorInstance, ZH_WORDS_GETTER("repaircontent.field.instance"), true, "");
	//故障资源描述
	API_DTO_FIELD(String, errorInstanceSource, ZH_WORDS_GETTER("repaircontent.field.source"), true, "");
	//维修情况
	API_DTO_FIELD(String, repairStatus, ZH_WORDS_GETTER("repaircontent.field.status"), true, "");

};

/**
 * 维修内容分页传输对象
 */
class RepaircontentPageDTO : public PageDTO<RepaircontentDTO::Wrapper>
{
	DTO_INIT(RepaircontentPageDTO, PageDTO<RepaircontentDTO::Wrapper>);
};
#include OATPP_CODEGEN_END(DTO)
#endif // !_REPAIRCONTENT_DTO_
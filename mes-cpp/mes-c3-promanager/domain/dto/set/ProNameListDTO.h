#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: xingshoulang
 @Date: 2024.5.21 2:57

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
#ifndef _PRONAMELISTDTO_H_
#define _PRONAMELISTDTO_H_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)
/**
 * 工序名称列表传输对象
 */
class ProNameListDTO : public oatpp::DTO
{
	DTO_INIT(ProNameListDTO, DTO);
	// 唯一标识
	API_DTO_FIELD(UInt64, processId, ZH_WORDS_GETTER("process.query.fields.proId"), true, 1);
	// 工序名称
	API_DTO_FIELD(String, proName, ZH_WORDS_GETTER("process.query.fields.proName"), true, "01star");
};

#include OATPP_CODEGEN_END(DTO)
#endif // _PRONAMELISTDTO_H_
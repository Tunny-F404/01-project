#pragma once
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
#ifndef _SAMPLE_DTO_
#define _SAMPLE_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 报工列表数据模型
 */
class FeedBackListDTO : public oatpp::DTO
{
	DTO_INIT(FeedBackListDTO,DTO);
	//报工类型
	API_DTO_FIELD(string, type,ZH_WORDS_GETTER());

};

/**
 * 示例分页传输对象
 */
class SamplePageDTO : public PageDTO<SampleDTO::Wrapper>
{
	DTO_INIT(SamplePageDTO, PageDTO<SampleDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_DTO_
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
#ifndef _DEVICEMANAGE_DTO_
#define _DEVICEMANAGE_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

class DeviceManageDTO : public oatpp::DTO
{
	DTO_INIT(DeviceManageDTO, DTO);

	//项目ID
	API_DTO_FIELD_DEFAULT(UInt64, subjectId, ZH_WORDS_GETTER("device-manage.field.subjectId"));

	//项目编码
	API_DTO_FIELD_DEFAULT(String, subjectCode, ZH_WORDS_GETTER("device-manage.field.subjectCode"));

	//项目名称
	API_DTO_FIELD_DEFAULT(String, subjectName, ZH_WORDS_GETTER("device-manage.field.subjectName"));

	//项目类型
	API_DTO_FIELD_DEFAULT(String, subjectType, ZH_WORDS_GETTER("device-manage.field.subjectType"));

	//项目内容
	API_DTO_FIELD_DEFAULT(String, subjectContent, ZH_WORDS_GETTER("device-manage.field.subjectContent"));

	//标准
	API_DTO_FIELD_DEFAULT(String, subjectStandard, ZH_WORDS_GETTER("device-manage.field.subjectStandard"));

	//是否启用
	API_DTO_FIELD_DEFAULT(String, enableFlag, ZH_WORDS_GETTER("device-manage.field.enableFlag"));

};

class DeviceManageDelDTO : public oatpp::DTO
{
	DTO_INIT(DeviceManageDelDTO, DTO);

	//项目ID
	API_DTO_FIELD_DEFAULT(String, subjectDelId, ZH_WORDS_GETTER("device-manage.field.subjectDelId"));

};


#include OATPP_CODEGEN_END(DTO)
#endif // !_DEVICEMANAGE_DTO_
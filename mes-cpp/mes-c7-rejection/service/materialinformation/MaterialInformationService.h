#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: 无名氏
 @Date: 2024/05/19 11:08:56

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
#ifndef _MaterialInformation_SERVICE_
#define _MaterialInformation_SERVICE_
#include <list>
#include "domain/dto/materialinformation/MaterialInformationDTO.h"
#include "domain/query/MaterialInformationQuery.h"

/**
 * 生产退料物料信息的服务接口
 */
class MaterialInformationService
{
public:
	
	// 保存数据
	uint64_t saveData(const MaterialInformationDTO::Wrapper& dto);

	// 分页查询所有数据
	MaterialInformationPageDTO::Wrapper listAll(const MaterialInformationQuery::Wrapper& query);

};

#endif // !_MaterialInformation_SERVICE_


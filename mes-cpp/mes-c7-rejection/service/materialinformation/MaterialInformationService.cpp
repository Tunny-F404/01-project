/*
 Copyright Zero One Star. All rights reserved.

 @Author: Œﬁ√˚ œ
 @Date: 2024/05/19 11:13:11

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
#include "stdafx.h"
#include "MaterialInformationService.h"

uint64_t MaterialInformationService::saveData(const MaterialInformationDTO::Wrapper& dto)
{
	return 1;
}

MaterialInformationPageDTO::Wrapper MaterialInformationService::listAll(const MaterialInformationQuery::Wrapper& query)
{
	return MaterialInformationPageDTO::Wrapper();
}

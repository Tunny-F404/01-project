#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 11:08:56

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
#ifndef _MATERIALPRODUCTSDTO_SERVICE_
#define _MATERIALPRODUCTSDTO_SERVICE_
#include <list>
#include "domain/vo/detectiontemplate/materialproductsVO.h"
#include "domain/query/detectiontemplate/materialproductsQuery.h"
#include "domain/dto/detectiontemplate/materialproductsDTO.h"
#include <oatpp/web/client/ApiClient.hpp>

class MaterialProductsService
{
public:
	// 分页查询所有数据
	MaterialProductsPageDTO::Wrapper listAll(const MaterialProductsQuery::Wrapper& query);
	
	uint64_t MaterialProductsService::saveMaterialProducts(const MaterialProductsDTO::Wrapper& dto);
	
	bool MaterialProductsService::updateMaterialProducts(const MaterialProductsDTO::Wrapper& dto);

	
	
	bool  MaterialProductsService::deleteByRecordId(const oatpp::List<oatpp::UInt64>& record_id);
};

#endif // !_SAMPLE_SERVICE_
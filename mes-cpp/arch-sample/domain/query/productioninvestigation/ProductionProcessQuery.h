#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: amie
 @Date: 2022/10/25 11:36:29

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
#ifndef _PROCESS_QUERY_
#define _PROCESS_QUERY_

#include "../../GlobalInclude.h"
#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 
 */
class ProductionProcessQuery : public oatpp::DTO{
	DTO_INIT(ProductionProcessQuery, DTO);
API_DTO_FIELD_DEFAULT(String, itemCode, ZH_WORDS_GETTER("productionorder.query.fields.item_code"));
API_DTO_FIELD_DEFAULT(String, itemName, ZH_WORDS_GETTER("productionorder.query.fields.item_name"));
API_DTO_FIELD_DEFAULT(String, productName, ZH_WORDS_GETTER("productionorder.query.fields.product_name"));
API_DTO_FIELD_DEFAULT(String, productCode, ZH_WORDS_GETTER("productionorder.query.fields.product_code"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_PROCESS_QUERY_
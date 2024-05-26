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
	API_DTO_FIELD_DEFAULT(String, workOrderCode, ZH_WORDS_GETTER("productionorder.query.fields.workorder_code"));
API_DTO_FIELD_DEFAULT(String, workOrderName, ZH_WORDS_GETTER("productionorder.query.fields.workorder_name"));
API_DTO_FIELD_DEFAULT(Int32, workOrderId, ZH_WORDS_GETTER("productionorder.query.fields.workorder_id"));
API_DTO_FIELD_DEFAULT(Int32, processId, ZH_WORDS_GETTER("productionprocess.query.fields.process_id"));
API_DTO_FIELD_DEFAULT(String, processName, ZH_WORDS_GETTER("productionprocess.query.fields.process_name"));


};

#include OATPP_CODEGEN_END(DTO)
#endif // !_PROCESS_QUERY_
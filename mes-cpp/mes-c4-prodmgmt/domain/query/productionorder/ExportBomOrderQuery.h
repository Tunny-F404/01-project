#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
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
#ifndef _BOM_QUERY_
#define _BOM_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 示例分页查询对象
 */
class ExportBomOrderQuery : public PageQuery
{
	DTO_INIT(ExportBomOrderQuery, PageQuery);
	API_DTO_FIELD_DEFAULT(String, WorkOrderCode, ZH_WORDS_GETTER("productionorder.query.fields.workroder_code"));
	API_DTO_FIELD_DEFAULT(Int32, workOrderId, ZH_WORDS_GETTER("productionorder.query.fields.workorder_id"));
	API_DTO_FIELD_DEFAULT(Int32, itemId, ZH_WORDS_GETTER("productionorder.query.fields.item_id"));
	API_DTO_FIELD_DEFAULT(String, itemCode, ZH_WORDS_GETTER("productionorder.query.fields.item_code"));
	API_DTO_FIELD_DEFAULT(String, itemName, ZH_WORDS_GETTER("productionorder.query.fields.item_name"));
	API_DTO_FIELD_DEFAULT(String, itemSpc, ZH_WORDS_GETTER("productionorder.query.fields.item_spc"));
	API_DTO_FIELD_DEFAULT(String, uintOfMeasure, ZH_WORDS_GETTER("productionorder.query.fields.unit_of_measure"));
	API_DTO_FIELD_DEFAULT(String, itemOrProduct, ZH_WORDS_GETTER("productionorder.query.fields.item_or_product"));
	API_DTO_FIELD_DEFAULT(Float64, quantity, ZH_WORDS_GETTER("productionorder.query.fields.quantity"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_BOM_QUERY_
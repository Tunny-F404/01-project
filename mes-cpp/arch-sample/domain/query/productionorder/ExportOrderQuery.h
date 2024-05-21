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
#ifndef _ORDER_QUERY_
#define _ORDER_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 示例分页查询对象
 */
class ExportOrderQuery : public PageQuery
{
	DTO_INIT(ExportOrderQuery, PageQuery);
	API_DTO_FIELD_DEFAULT(String, workOrderCode, ZH_WORDS_GETTER("productionorder.query.fields.workorder_code"));
	API_DTO_FIELD_DEFAULT(String, workOrderName, ZH_WORDS_GETTER("productionorder.query.fields.workorder_name"));
	API_DTO_FIELD_DEFAULT(String, workOrderType, ZH_WORDS_GETTER("productionorder.query.fields.workorder_type"));
	API_DTO_FIELD_DEFAULT(String, orderSource, ZH_WORDS_GETTER("productionorder.query.fields.order_source"));
	API_DTO_FIELD_DEFAULT(String, sourceCode, ZH_WORDS_GETTER("productionorder.query.fields.source_code"));
	API_DTO_FIELD_DEFAULT(Int32, productId, ZH_WORDS_GETTER("productionorder.query.fields.product_id"));
	API_DTO_FIELD_DEFAULT(String, productCode, ZH_WORDS_GETTER("productionorder.query.fields.product_code"));
	API_DTO_FIELD_DEFAULT(String, productName, ZH_WORDS_GETTER("productionorder.query.fields.product_name"));
	API_DTO_FIELD_DEFAULT(String, productSpc, ZH_WORDS_GETTER("productionorder.query.fields.product_spc"));
	API_DTO_FIELD_DEFAULT(String, unitOfMeasure, ZH_WORDS_GETTER("productionorder.query.fields.unit_of_measure"));
	API_DTO_FIELD_DEFAULT(String, batchCode, ZH_WORDS_GETTER("productionorder.query.fields.batch_code"));
	API_DTO_FIELD_DEFAULT(Float64,pQuantity, ZH_WORDS_GETTER("productionorder.query.fields.pquantity"));
	API_DTO_FIELD_DEFAULT(Float64, quantityProduced,ZH_WORDS_GETTER("productionorder.query.fields.quantity_produced"));
	API_DTO_FIELD_DEFAULT(Float64, quantityChanged, ZH_WORDS_GETTER("productionorder.query.fields.quantity_changed"));
	API_DTO_FIELD_DEFAULT(Float64, quantityScheduled, ZH_WORDS_GETTER("productionorder.query.fields.quantity_scheduled"));
	API_DTO_FIELD_DEFAULT(Float64, clientId, ZH_WORDS_GETTER("productionorder.query.fields.client_id"));
	API_DTO_FIELD_DEFAULT(String, clientCode, ZH_WORDS_GETTER("productionorder.query.fields.client_code"));
	API_DTO_FIELD_DEFAULT(String, clientName, ZH_WORDS_GETTER("productionorder.query.fields.client_name"));
	API_DTO_FIELD_DEFAULT(Float64, vendorId, ZH_WORDS_GETTER("productionorder.query.fields.vendor_id"));
	API_DTO_FIELD_DEFAULT(String, vendorCode, ZH_WORDS_GETTER("productionorder.query.fields.vendor_code"));
	API_DTO_FIELD_DEFAULT(String, vendorName, ZH_WORDS_GETTER("productionorder.query.fields.vendor_name"));
	API_DTO_FIELD_DEFAULT(String, finishDate, ZH_WORDS_GETTER("productionorder.query.fields.finish_date"));
	API_DTO_FIELD_DEFAULT(String, requestDate, ZH_WORDS_GETTER("productionorder.query.fields.request_date"));
	API_DTO_FIELD_DEFAULT(String, status, ZH_WORDS_GETTER("productionorder.query.fields.status"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_ORDER_QUERY_
